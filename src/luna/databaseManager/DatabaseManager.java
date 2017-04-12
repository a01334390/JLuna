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

import BasicElements.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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
            ResultSet resultset = statement.executeQuery("SELECT * FROM User WHERE username='" + username + "';");
            while (resultset.next()) {
                return new Session(resultset.getString("username"), resultset.getString("email"), resultset.getString("first_name"), resultset.getString("second_name"), resultset.getString("privilege"), resultset.getString("image"));
            }
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return new Session();
    }

    /**
     * This method returns the username the user looked for
     *
     * @param username, as a string
     * @return an object User
     */
    public static User searchUsername(String username) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pola", "superadmin", "superadmin123");
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM User WHERE username='" + username + "';");
            while (resultset.next()) {
                return new User(resultset.getString("username"), resultset.getString("privilege"), resultset.getString("email"), resultset.getString("first_name"), resultset.getString("second_name"), resultset.getString("image"));
            }
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }

    /**
     * Adds a new user to the database
     *
     * @param user, as an User in the database
     * @return a boolean if it was possible or not
     */
    public static boolean addUserToDatabase(User user) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pola", "superadmin", "superadmin123");
            Statement statement = connection.createStatement();
            int rowsaffected = statement.executeUpdate("INSERT INTO User VALUES ('" + user.getUsername() + "' , '" + user.getEmail() + "' , '" + user.getPassword() + "' , '" + user.getPrivilege() + "' , '" + user.getFirst_name() + "' , '" + user.getSecond_name() + "' , '" + user.getImage() + "' , '" + dateToString() + "') ;");
            return rowsaffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return false;
    }

    /**
     * Edits an user based on the username (cant be changed)
     *
     * @param user, based on an user element
     * @return a boolean if it was possible
     */
    public static boolean editUserInDatase(User user) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pola", "superadmin", "superadmin123");
            Statement statement = connection.createStatement();
            int rowsaffected = statement.executeUpdate(
                    "UPDATE User"
                    + " SET username='" + user.getUsername() + "',email='" + user.getEmail() + "',password='" + user.getPassword() + "',privilege='" + user.getPrivilege() + "',first_name='" + user.getFirst_name() + "',second_name='" + user.getSecond_name() + "',image='" + user.getImage() + "',create_time='" + dateToString() + "'"
                    + " WHERE username='" + user.getUsername() + "';");
            return rowsaffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getSQLState() + "," + e.getLocalizedMessage()); //Must be a JPopup or something

        }
        return false;
    }
    
    private static String dateToString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        java.util.Date date = new java.util.Date();
        return dateFormat.format(date);
    }
    
    public static boolean deleteUserInDatabase(String usname) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pola", "superadmin", "superadmin123");
            Statement statement = connection.createStatement();
            int rowsaffected = statement.executeUpdate("DELETE FROM User WHERE username='" + usname + "';");
            return rowsaffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return false;
    }

    /**
     * Returns an Array filled with all users in the database
     *
     * @return all users in an ArrayList
     */
    public static User[] getAllUsers() {
        ArrayList<User> array = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pola", "superadmin", "superadmin123");
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM User;");
            while (resultset.next()) {
                array.add(new User(resultset.getString("username"), resultset.getString("privilege"), resultset.getString("email"), resultset.getString("first_name"), resultset.getString("second_name"), resultset.getString("image")));
            }
            return array.toArray(new User[array.size()]);
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }

    //From this point on, all Queries are material based
    /**
     *
     * @return
     */
    public static Material[] getAllMaterials() {
        ArrayList<Material> array = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pola", "superadmin", "superadmin123");
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Material;");
            while (resultset.next()) {
                array.add(new Material(resultset.getInt("idMaterial"), resultset.getString("name"), resultset.getInt("quantity"), resultset.getFloat("cost")));
            }
            return array.toArray(new Material[array.size()]);
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }

    /**
     *
     * @param matname
     * @return
     */
    public static boolean deleteMaterialInDatabase(String matname) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pola", "superadmin", "superadmin123");
            Statement statement = connection.createStatement();
            int rowsaffected = statement.executeUpdate("DELETE FROM Material WHERE name='" + matname + "';");
            return rowsaffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return false;
    }

    /**
     *
     * @param mat
     * @return
     */
    public static boolean addMaterialToDatabase(Material mat) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pola", "superadmin", "superadmin123");
            Statement statement = connection.createStatement();
            int rowsaffected = statement.executeUpdate("INSERT INTO Material(name,quantity,cost) VALUES ('" + mat.getName() + "' , '" + mat.getQuantity() + "' , '" + mat.getCost() + "') ;");
            return rowsaffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return false;
    }

    /**
     *
     * @param mat
     * @return
     */
    public static boolean editMaterialInDatabase(Material mat) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pola", "superadmin", "superadmin123");
            Statement statement = connection.createStatement();
            int rowsaffected = statement.executeUpdate("UPDATE Material SET name='" + mat.getName() + "' , quantity='" + mat.getQuantity() + "' , cost='" + mat.getCost() + "' WHERE idMaterial=" + mat.getId() + " ;");
            return rowsaffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return false;
    }

    /**
     *
     * @param searname
     * @return
     */
    public static Material searchMaterial(String searname) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pola", "superadmin", "superadmin123");
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Material WHERE name='" + searname + "';");
            while (resultset.next()) {
                return new Material(resultset.getInt("idMaterial"), resultset.getString("name"), resultset.getInt("quantity"), resultset.getFloat("cost"));
            }
            return null;
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }

    /**
     *
     * @param id
     * @return
     */
    public static boolean deleteClient(int id) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pola", "superadmin", "superadmin123");
            Statement statement = connection.createStatement();
            int rowsaffected = statement.executeUpdate("DELETE FROM Client WHERE idClient='" + Integer.toString(id) + "';");
            return rowsaffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return false;
    }

    /**
     *
     * @param id
     * @return
     */
    public static Cliente searchClientByID(String id) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pola", "superadmin", "superadmin123");
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Client WHERE idClient='" + id + "';");
            while (resultset.next()) {
                return new Cliente(resultset.getInt("idClient"), resultset.getString("first_name"), resultset.getString("second_name"), resultset.getString("address"), resultset.getInt("isPhysical"));
            }
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }

    /**
     *
     * @param name
     * @return
     */
    public static Cliente searchClientByName(String name) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pola", "superadmin", "superadmin123");
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Client WHERE first_name='" + name + "' OR second_name='" + name + "';");
            while (resultset.next()) {
                return new Cliente(resultset.getInt("idClient"), resultset.getString("first_name"), resultset.getString("second_name"), resultset.getString("address"), resultset.getInt("isPhysical"));
            }
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }

    /**
     *
     * @param currentClient
     * @return
     */
    public static boolean addClientToDatabase(Cliente cli) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pola", "superadmin", "superadmin123");
            Statement statement = connection.createStatement();
            int rowsaffected = statement.executeUpdate("INSERT INTO Client(first_name,second_name,address,isPhysical) VALUES ('" + cli.getFirst_name() + "' , '" + cli.getSecond_name() + "' , '" + cli.getAddress() + "','" + cli.getIsPhysical() + "') ;");
            return rowsaffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return false;
    }

    /**
     *
     * @param currentClient
     * @return
     */
    public static boolean editClientInDatabase(Cliente cli) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pola", "superadmin", "superadmin123");
            Statement statement = connection.createStatement();
            int rowsaffected = statement.executeUpdate("UPDATE Client SET first_name='" + cli.getFirst_name() + "' , second_name='" + cli.getSecond_name() + "' , address='" + cli.getAddress() + "',isPhysical='" + cli.getIsPhysical() + "' WHERE idClient=" + cli.getId() + " ;");
            return rowsaffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return false;
    }

    /**
     *
     * @return
     */
    public static Cliente[] getAllClients() {
        ArrayList<Cliente> array = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pola", "superadmin", "superadmin123");
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Client;");
            while (resultset.next()) {
                array.add(new Cliente(resultset.getInt("idClient"), resultset.getString("first_name"), resultset.getString("second_name"), resultset.getString("address"), resultset.getInt("isPhysical")));
            }
            return array.toArray(new Cliente[array.size()]);
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }
    
    /**
     *
     * @param clientID
     * @return
     */
    public static Order[] getOrdersFromClient(int clientID) {
        ArrayList<Order> array = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pola", "superadmin", "superadmin123");
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Order WHERE client_id= '" + Integer.toString(clientID) + "';");
            while (resultset.next()) {
                array.add(new Order(resultset.getInt("idOrder"), resultset.getDate("date").toString(), resultset.getString("priority"), resultset.getDate("create_time").toString(), resultset.getInt("client_id")));
            }
            return array.toArray(new Order[array.size()]);
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }
    
    /**
     *
     * @param orderID
     * @return
     */
    public static Order searchOrderByID(String orderID) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pola", "superadmin", "superadmin123");
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Order WHERE idOrder= '" + orderID + "';");
            while (resultset.next()) {
                return new Order(resultset.getInt("idOrder"), resultset.getDate("date").toString(), resultset.getString("priority"), resultset.getDate("create_time").toString(), resultset.getInt("client_id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }
    
    /**
     *
     * @param id
     * @return
     */
    public static OrderNotebooks[] getOrderNotebookBasicView(int id) {
        ArrayList<OrderNotebooks> array = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pola", "superadmin", "superadmin123");
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Notebook_Order WHERE id_Order= '" + Integer.toString(id) + "';");
            while (resultset.next()) {
                array.add(new OrderNotebooks(resultset.getInt("id_Notebook"), resultset.getInt("id_Order"), resultset.getInt("quantity"), resultset.getString("status"), resultset.getInt("id_Customization")));
            }
            return array.toArray(new OrderNotebooks[array.size()]);
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }
    
    /**
     *
     * @param idNotebook
     * @param idOrder
     * @return
     */
    public static AVOrderNotebook searchNotebookON(String idNotebook, int idOrder) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Pola", "superadmin", "superadmin123");
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT Notebook.type,Customization.ribbon,Customization.elastic,Customization.pageType,Customization.image "
                    + "FROM ((Notebook_Order INNER JOIN Notebook ON Notebook_Order.id_Notebook = Notebook.idNotebook) "
                    + "INNER JOIN Customization ON Notebook_Order.id_Customization = Customization.idCustomization) "
                    + "WHERE id_Order = "+idOrder+" AND id_Notebook = "+Integer.parseInt(idNotebook)+"");
            while (resultset.next()) {
                return new AVOrderNotebook(resultset.getString("type"), resultset.getString("ribbon"), resultset.getString("elastic"), resultset.getString("pageType"), resultset.getString("image"));
            }
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }
    
}
