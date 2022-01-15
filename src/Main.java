import ch.heg.ig.sda.business.Lesson;
import ch.heg.ig.sda.business.Student;
import ch.heg.ig.sda.io.EdulearnCSV;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        EdulearnCSV edu = new EdulearnCSV();
        edu.setCsvPath("C:\\Users\\Admin\\Documents\\jsprojects\\Edulearn\\data\\Students.csv");

        // Mesure temporelle

        long startTime = System.currentTimeMillis();
        edu.loadStudents();
        long endTime = System.currentTimeMillis();
        System.out.println("Students load (5000) " + (endTime - startTime) + "ms");

        edu.setCsvPath("C:\\Users\\Admin\\Documents\\jsprojects\\Edulearn\\data\\Lessons.csv");

        startTime = System.currentTimeMillis();
        edu.loadLessons();
        endTime = System.currentTimeMillis();
        System.out.println("Lessons load (95) " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        Student student = edu.getStudentByRegiNumber("5000");
        endTime = System.currentTimeMillis();
        System.out.println("Get student '" + student.getLastname()
                                           + "' in list (at position 5000) "
                                           + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        student = edu.getStudentByRegiNumber("1");
        List<Lesson> lessonsOwned = edu.getAllOwnLessons(student);
        endTime = System.currentTimeMillis();
        System.out.println("Get all lessons owned of '" + student.getLastname()
                                                        + "' (count: " + lessonsOwned.size()
                                                        + ") " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        edu.displayLessons();
        edu.displayStudents();
        endTime = System.currentTimeMillis();
        System.out.println("Display lessons and students (5095) " + (endTime - startTime) + "ms");
    }

}