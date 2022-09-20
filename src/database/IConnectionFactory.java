/*
 * Course: SE 2030 031
 * Fall 2022
 * GeneralTransitFeedSpecificationTool - database.IConnectionFactory
 * Name: Wesley Jochman
 * Created: 9/19/2022
 */
package database;

import java.sql.Connection;

/**
 * Interface for the Connection Factory
 */
public interface IConnectionFactory {
    /**
     * Connects to the database
     * @return SQLConnection
     */
    Connection connect();
}
