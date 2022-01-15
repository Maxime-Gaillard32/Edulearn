package ch.heg.ig.sda.io;

import ch.heg.ig.sda.business.Lesson;
import ch.heg.ig.sda.business.Student;
import com.univocity.parsers.common.processor.RowListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import java.io.File;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Class EdulearnCSV.
 */
public class EdulearnCSV extends AbstractEdulearn{
    private String csvPath;

    /**
     * Load students from CSV.
     */
    @Override
    public void loadStudents() {
        File file = new File(csvPath);
        List<String[]> csvStudents = parseCSV(file);
        csvStudents.remove(0);

        for (String[] currentStudent : csvStudents) {
            this.addStudent(new Student(Integer.parseInt(currentStudent[0]),
                                                         currentStudent[1],
                                                         currentStudent[2],
                                                         currentStudent[3],
                                                         currentStudent[4])
            );
        }

    }

    /**
     * Load lessons from CSV.
     */
    @Override
    public void loadLessons() {
        File file = new File(csvPath);
        List<String[]> csvLessons = parseCSV(file);
        csvLessons.remove(0);

        for (String[] currentLesson : csvLessons) {
            this.addNewLesson(new Lesson(Integer.parseInt(currentLesson[0]),
                                         currentLesson[1],
                                         currentLesson[2],
                                         Double.parseDouble(currentLesson[3]),
                                         this.getStudentByRegiNumber(currentLesson[4]))
            );
        }
    }

    /**
     * Get CSV path.
     * @return The CSV file path.
     */
    public String getCsvPath() {
        return csvPath;
    }

    /**
     * Set the CSV file path.
     * @param csvPath The CSV file path.
     */
    public void setCsvPath(String csvPath) {
        this.csvPath = csvPath;
    }

    /**
     * Parse the CSV file to String array.
     * @param file The CSV file.
     * @return String array of csv content.
     */
    public static List<String[]> parseCSV(File file) {
        CsvParserSettings settings = new CsvParserSettings();
        settings.setMaxCharsPerColumn(1048576); // change the limit if needed
        settings.setLineSeparatorDetectionEnabled(true);
        settings.setDelimiterDetectionEnabled(true);
        RowListProcessor rowProcessor = new RowListProcessor();
        settings.setProcessor(rowProcessor);
        settings.setHeaderExtractionEnabled(false);
        CsvParser parser = new CsvParser(settings);
        parser.parse(file);
        List<String[]> rows = rowProcessor.getRows();
        return rows;
    }

}
