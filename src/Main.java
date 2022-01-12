import ch.heg.ig.sda.io.EdulearnCSV;

public class Main {

    public static void main(String[] args) {
        EdulearnCSV edu = new EdulearnCSV();
        edu.setCsvPath("C:\\Users\\Admin\\Documents\\jsprojects\\Edulearn\\data\\Students.csv");
        edu.loadStudents();
    }

}