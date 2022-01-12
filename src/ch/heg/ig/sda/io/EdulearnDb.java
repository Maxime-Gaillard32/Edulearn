package ch.heg.ig.sda.io;

import ch.heg.ig.sda.business.Lesson;
import ch.heg.ig.sda.business.Student;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * DbTool util class.
 */
public class EdulearnDb extends AbstractEdulearn {

    /**
     * Get the database connection.
     * @return The database connection.
     */
    private Connection getConnection() {
        return null;
    }

    /**
     * Load all students from database.
     */
    @Override
    public Map<String, Student> loadStudents() {
        return null;
    }

    /**
     * Load all lessons from database.
     */
    @Override
    public Map<String, Lesson> loadLessons() {
        return null;
    }
}
