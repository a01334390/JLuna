/*
 * Copyright (c) 2017 a01334390.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    a01334390 - initial API and implementation and/or initial documentation
 */
package luna.databaseManager;

import java.sql.*;

/**
 *
 * @author a01334390
 */
public class DatabaseManager {

    /**
     * This method validates if the user exit, however, it does so without ever
     * touching the password
     *
     * @param username, as String
     * @param password, as String
     * @return if the user exists in the database
     */
    public static boolean userValidation(String username, char[] password) {
        String pass = new String(password);
        int count = 0;
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pola", "superadmin", "superadmin123");
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT username FROM User WHERE username='" + username + "' AND password='" + pass + "'");
            //if there is no data on the data set, the session return will be false
            while (resultset.next()) {
                count++;
            }
            statement.close();
            connection.close();
            return count != 0;
            //return session;
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return false;
    }

    /**
     * This method returns an object session to be used during the application's
     * lifetime
     *
     * @param username, a String to search for it on the database
     * @return a Session if found (should return something)
     */
    public static Session userSessionCreation(String username) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pola", "superadmin", "superadmin123");
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM User WHERE username='"+username+"';");
            while (resultset.next()) {
                return new Session(resultset.getString("username"), resultset.getString("email"), resultset.getString("first_name"), resultset.getString("second_name"), resultset.getString("privilege"), resultset.getString("image"));
            }
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return new Session();
    }
}
