/*
 * Course: SE 2030 031
 * Fall 2022
 * GeneralTransitFeedSpecificationTool - database.ConnectionFactory
 * Name: Wesley Jochman
 * Created: 9/19/2022
 */

package database;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Builds and connects to the sqlite database
 */
public class ConnectionFactory implements IConnectionFactory {
    private static final String DATABASE_PATH = "jdbc:sqlite";
    private static final String DATABASE_FILE = "main.db";
    private final String url;

    /**
     * Instance of the Connection Factory
     */
    public static ConnectionFactory instance = new ConnectionFactory();

    /**
     * Connection Factory
     */
    private ConnectionFactory() {
        url = generateDatabase();
    }

    private static String generateDatabase() {
        File database = new File("./sqlite/db/");
        if (database.mkdirs()) {
            System.out.println("Database created");
        }
        return "%s:%s/%s".formatted(DATABASE_PATH, database.getAbsolutePath(), DATABASE_FILE);
    }

    @Override
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
}
