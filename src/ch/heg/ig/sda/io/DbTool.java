package ch.heg.ig.sda.io;

import ch.heg.ig.sda.business.ConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * DbTool util class.
 */
public class DbTool extends AbstractEdulearn {
    private Connection cnn = null;

    public void openConnection() throws SQLException {
        cnn = new ConnectionPool().getConnection();
    }
    public void closeConnection() throws SQLException {
        cnn.close();
    }

    /**
     * Get the database connection.
     * @return The database connection.
     */
    private Connection getConnection(){
        return cnn;
    }

    /**
     * Load all students from database.
     */
    @Override
    public void loadStudents() {

    }

    /**
     * Load all documents from database.
     */
    @Override
    public void loadDocuments() {

    }

    /**
     * Load all lessons from database.
     */
    @Override
    public void loadLessons() {

    }
}
