package ch.heg.ig.sda.io;

import ch.heg.ig.sda.business.Student;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class EdulearnCSV extends AbstractEdulearn{

    private String csvPath;
    private List<Student> studentList;
    @Override
    public void loadStudents() {
        try {
            this.getAllStudent().addAll(new CsvToBeanBuilder(new FileReader(csvPath))
                    .withType(Student.class)
                    .build()
                    .parse());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        this.getAllStudent().forEach(System.out::println);
    }

    @Override
    public void loadDocuments() {

    }

    @Override
    public void loadLessons() {

    }
    public String getCsvPath() {
        return csvPath;
    }

    public void setCsvPath(String csvPath) {
        this.csvPath = csvPath;
    }

}
