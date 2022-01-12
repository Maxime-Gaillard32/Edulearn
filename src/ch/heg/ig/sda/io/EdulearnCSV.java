package ch.heg.ig.sda.io;

import ch.heg.ig.sda.business.Lesson;
import ch.heg.ig.sda.business.Student;
import com.univocity.parsers.common.processor.RowListProcessor;
import com.univocity.parsers.csv.CsvParser;
import com.univocity.parsers.csv.CsvParserSettings;

import java.io.File;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EdulearnCSV extends AbstractEdulearn{

    private List<Student> students = new ArrayList<>();
    private List<Lesson> lessons = new ArrayList<>();
    private String csvPath;
    private List<String[]> strings;
    @Override
    public void loadStudents() {
        File file = new File(csvPath);
        strings = parseCSV(file);
        strings.remove(0);
        for (String[] student:strings) {
            System.out.println(student[0]+" "+student[1]+" "+student[2]+" "+student[3]+""+student[3]);
            students.add(new Student(Integer.parseInt(student[0]),student[1],student[2],student[3],student[4]));
        }

    }

    @Override
    public void loadDocuments() {


    }

    @Override
    public void loadLessons() {
        File file = new File(csvPath);
        strings = parseCSV(file);
        strings.remove(0);
        for (String[] lesson:strings) {
            System.out.println(lesson[0]+" "+lesson[1]+" "+lesson[2]);
            students.add(new Lesson(Integer.parseInt(lesson[0]),lesson[1],Float.parseFloat(lesson[2])));
        }
    }

    public String getCsvPath() {
        return csvPath;
    }

    public void setCsvPath(String csvPath) {
        this.csvPath = csvPath;
    }

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
