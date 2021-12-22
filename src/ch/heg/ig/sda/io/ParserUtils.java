package ch.heg.ig.sda.io;

import com.univocity.parsers.common.processor.RowListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;
import com.univocity.parsers.tsv.TsvParser;
import com.univocity.parsers.tsv.TsvParserSettings;
import com.univocity.parsers.tsv.TsvWriter;
import com.univocity.parsers.tsv.TsvWriterSettings;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;


/**
 *  This class use Univocity CSV.
 *  Source : https://www.univocity.com/pages/univocity_parsers_tsv.html#working-with-tsv
 *  Source : https://www.univocity.com/pages/univocity_parsers_documentation
 */
public class ParserUtils {

    private static final String CRLF = "\r\n";
    private static final String TAB = "\t";

    public static List<String[]> parseTSV(String filepath) throws IOException {
        File file = new File(filepath);
        if(!file.exists()){
            throw new IOException("File not exist at path: " + file);
        }
        return parseTSV(file);
    }

    /**
         * Parse TSV file to a list of string array.
         * TODO Optimise parseAll for big file : https://stackoverflow.com/questions/13879967/good-and-effective-csv-tsv-reader-for-java/27087060
         * @param file
         * @return
         */
    public static List<String[]> parseTSV(File file) {
        TsvParserSettings settings = new TsvParserSettings();
        settings.getFormat().setLineSeparator(CRLF);

        // creates a TSV parser
        TsvParser parser = new TsvParser(settings);

        // parses all rows in one go.
        List<String[]> lines = new LinkedList<>(); //= parser.parseAll(file);

        // call beginParsing to read records one by one, iterator-style.
        parser.beginParsing(file);

        String[] row;
        while ((row = parser.parseNext()) != null) {
            lines.add(row);
        }

        // The resources are closed automatically when the end of the input is reached,
        // or when an error happens, but you can call stopParsing() at any time.
        // You only need to use this if you are not parsing the entire content.
        // But it doesn't hurt if you call it anyway.
        parser.stopParsing();

        System.out.println("ParserUtils.parseTSV: " + file.getName() + " that contains " + lines.size() + " lines.");

        //##CODE_END

        //ParserUtils.printParsedTSV(lines); // Debug only

        return lines;
    }

    public static Map<Integer, String[]> parseTSVToMap(String filepath, int keyColumnIndex, int rowStart) throws IOException {
        File file = new File(filepath);
        if(!file.exists()){
            throw new IOException("File not exist at path: " + file);
        }
        return parseTSVToMap(file, keyColumnIndex, rowStart);
    }

    /**
     * Parse a file and store into a map.
     * @param file File to parse
     * @param keyColumnIndex Column index that will bs the key value.
     * @param rowStart Index of row start. Eg. 0 = with header, 1 = without header
     * @return
     */
    public static Map<Integer, String[]> parseTSVToMap(File file, int keyColumnIndex, int rowStart) {
        TsvParserSettings settings = new TsvParserSettings();
        settings.getFormat().setLineSeparator(CRLF);
        TsvParser parser = new TsvParser(settings);
        List<String[]> lines = parser.parseAll(file);

        System.out.println("ParserUtils.parseTSV: " + file.getName() + " that contains " + lines.size() + " lines.");

        Map<Integer, String[]> map = new TreeMap<>();
        for(int i = rowStart; i < lines.size(); i++){
            int key = Integer.parseInt(lines.get(i)[keyColumnIndex]);
            map.put(key, lines.get(i));
        }

        return map;
    }

    /**
     * Load a CSV file into a List of String[].
     * setMaxCharsPerColumn: default value = 4096 = 2^12, updated value = 1048576 = 2^20
     * @param file CSV file.
     * @return File content with header.
     */
    public static List<String[]> parseCSV(File file) {
        CsvParserSettings settings = new CsvParserSettings();
        settings.setMaxCharsPerColumn(1048576); // change the limit if needed
        settings.setLineSeparatorDetectionEnabled(true);
        RowListProcessor rowProcessor = new RowListProcessor();
        settings.setProcessor(rowProcessor);
        settings.setHeaderExtractionEnabled(false);
        CsvParser parser = new CsvParser(settings);
        parser.parse(file);
        List<String[]> rows = rowProcessor.getRows();
        return rows;
    }

    /**
     * Parse CSV header.
     * @param filepath
     * @param maxCharsPerColumn Higher than 4096
     * @return
     */
    public static String[] parseCSVHeader(String filepath, final int maxCharsPerColumn){
        File file = new File(filepath);
        CsvParserSettings settings = new CsvParserSettings();
        settings.setMaxCharsPerColumn(maxCharsPerColumn);
        settings.setLineSeparatorDetectionEnabled(true);
        settings.setHeaderExtractionEnabled(true);
        RowListProcessor rowProcessor = new RowListProcessor();
        settings.setRowProcessor(rowProcessor);
        CsvParser parser = new CsvParser(settings);
        parser.parse(file);
        String[] headers = rowProcessor.getHeaders();
        return headers;
    }

    /**
     * Parse a CSV file.
     * @param filename
     * @return
     */
    public static List<String[]> parseCSV(String filename){
        File file = new File(filename);
        return parseCSV(file);
    }

    /**
     * Load a CSV file into a List of String[].
     * References columns contains long String
     * - setMaxCharsPerColumn default value = 4096 {@link CsvParserSettings#getMaxCharsPerColumn()}
     * - Actual value : 2^20 = 1048576
     * - Max value : {@link Integer#MAX_VALUE} (max String length)
     * @param filePath CSV file path.
     * @return File content with header.
     * @implNote Use ArrayList as implementation with pre-determined capacity.
     * @see {https://www.univocity.com/pages/univocity_parsers_tutorial#parsing-with-rowprocessors}
     */
    public static List<String[]> parseCSVUpdated(String filePath) throws FileNotFoundException {

        CsvParserSettings parserSettings = new CsvParserSettings();
        // Automatically detect what line separator sequence is in the input
        parserSettings.setLineSeparatorDetectionEnabled(true);
        // Change the limit because of reference
        parserSettings.setMaxCharsPerColumn(1048576); // change the limit if needed
        // A RowListProcessor stores each parsed row in a List.
        RowListProcessor rowProcessor = new RowListProcessor();
        // Configure the parser to use a RowProcessor to process the values of each parsed row.
        parserSettings.setProcessor(rowProcessor);
        // Consider the first parsed row as the headers of each column in the file.
        parserSettings.setHeaderExtractionEnabled(true);

        // creates a parser instance with the given settings
        CsvParser parser = new CsvParser(parserSettings);

        Reader inputReader = new InputStreamReader(new FileInputStream(
                new File(filePath)), StandardCharsets.UTF_8);

        // Parse the file and delegate each parsed row to the RowProcessor you defined
        parser.parse(inputReader); // getReader(filePath)

        // get the parsed records from the RowListProcessor here.
        // Note that different implementations of RowProcessor will provide different sets of functionalities.
        String[] headers = rowProcessor.getHeaders();
        List<String[]> rows = rowProcessor.getRows();
        rows.add(0, headers);

        return rows;
    }

    public static List<List<String>> parseCSVUpdated(String filePath, boolean keepHeader) throws FileNotFoundException {
        List<String[]> rows = parseCSV(filePath);

        int size = rows.size();
        if (!keepHeader)
            size = size - 1;

        int startIndex = 0;
        List<List<String>> records = new ArrayList<>(size);
        if (!keepHeader)
            startIndex = 1;

        for (int i = startIndex; i < rows.size(); i++) {
            records.add(Arrays.asList(rows.get(i)));
        }

        return records;
    }

    public static void printParsedTSV(List<String[]> list) {
        System.out.println("Show TSV content: " + list.size());
        StringBuilder result = new StringBuilder();
        StringBuilder line;

        for (int i = 0; i < list.size(); i++) {

            int j = 0;
            line = new StringBuilder();
            for (String lineItem : list.get(i)) {
                line.append(lineItem);
                if (j < list.get(i).length - 1)
                    line.append(TAB);

                j++;
            }

            line.append(CRLF);
            result.append(line.toString());
        }

        System.out.println(result.toString());
    }

    /**
     * Create a file with the content given.
     * @param file
     * @param content
     * @throws IOException
     */
    public static void createTSVFile(File file, List<String[]> content) throws IOException {
        System.out.println("CREATE FILE, size : " + content.size());

        file.createNewFile();
        Writer out = new FileWriter(file);
        TsvWriterSettings writerSettings = new TsvWriterSettings();
        writerSettings.getFormat().setLineSeparator(CRLF);
        TsvWriter writer = new TsvWriter(out, writerSettings);

        StringBuilder line;
        for (int i = 0; i < content.size(); i++) {

            int j = 0;
            line = new StringBuilder();
            for (String lineItem : content.get(i)) {
                line.append(lineItem);
                if (j < content.get(i).length - 1)
                    line.append(TAB);

                j++;
            }

            writer.writeRow(line.toString());
        }

        writer.close();
    }

    public static void createTSVFile(File file, String stringToWrite) throws IOException {
        file.createNewFile();
        Writer out = new FileWriter(file);
        TsvWriterSettings writerSettings = new TsvWriterSettings();
        writerSettings.getFormat().setLineSeparator(CRLF);
        TsvWriter writer = new TsvWriter(out, writerSettings);
        writer.writeRow(stringToWrite);
        writer.close();
    }

}
