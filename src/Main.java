import ch.heg.ig.sda.io.EdulearnCSV;

public class Main {

    public static void main(String[] args) {
        EdulearnCSV edu = new EdulearnCSV();
        edu.setCsvPath("C:\\Users\\maxime.gaillard3\\OneDrive - HE-ARC\\Documents\\GitHub\\Edulearn\\data\\Students.csv");
        edu.loadStudents();
    }

}