/*
 * Course: SE 2030 031
 * Fall 2022
 * GeneralTransitFeedSpecificationTool - tests.integration.ConnectionFactoryTests
 * Name: Wesley Jochman
 * Created: 9/19/2022
 */

package tests.integration;

import database.ConnectionFactory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Tests for ConnectionFactory
 */
public class ConnectionFactoryTests {

    /**
     * Tests the connection to the database
     * @throws SQLException Can't connect
     */
    @Test
    @DisplayName("Connect to database")
    public void connect() throws SQLException {
        ConnectionFactory factory = new ConnectionFactory();
        try (Connection conn = factory.connect()) {
            Assert.assertFalse(conn.isClosed());
        }
    }

    /**
     * Creates the database and checks if it exists
     */
    @Test
    @DisplayName("Create database")
    public void createDatabase() {
        File database = new File("./sqlite/db/");
        new ConnectionFactory();
        Assert.assertTrue(database.exists());
    }
}