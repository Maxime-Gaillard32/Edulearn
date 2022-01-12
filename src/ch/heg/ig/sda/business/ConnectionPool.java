package ch.heg.ig.sda.business;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionPool {
    private final String DBURL = "jdbc:oracle:thin:@db.ig.he-arc.ch:1521:ens";
    private final String DBUSER = "MAXIME_GAILLARD3";
    private final String DBPWD = "MAXIME_GAILLARD3";
    private Connection cnn = null;
    public Connection getConnection() throws SQLException {
        cnn = DriverManager.getConnection(DBURL, DBUSER, DBPWD);
        cnn.setAutoCommit(false);
        return cnn;
    }
    public void closeConnection() throws SQLException {
        cnn.close();
    }
}
