/*
 * Name: Horace Vial
 * Date: 12/05/2025
 * Creates a connection to the SQLite database file.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteDatabase {

    // Opens a connection to the SQLite database
    public static Connection connect(String database) {
        String url = "jdbc:sqlite:" + database;
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }
}
