/*
 * Built in 2017© By Worker's in Kraken Tech Ltd.
 * Compiled and Revised by Advisors outside the company
 * Refer to documentation attached for any other reference on code or anything related to this Source Code
 */
package DatabaseManager;

import AdvancedElements.HighestBenefitCC;
import BasicElements.*;
import Servlets.HighestBenefit;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author a01334390
 */
public class Handler {

    private static String host = "jdbc:mysql://35.188.87.36/Pola";
    private static String huser = "superuser";
    private static String hpassword = "superuser123";

    /**
     * This method validates if the user exit, however, it does so without ever
     * touching the password
     *
     * @param username, as String
     * @param password, as String
     * @return if the user exists in the database
     */
    public static boolean userValidation(String username, String password) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        int count = 0;
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT username FROM User WHERE username='" + username + "' AND password='" + password + "'");
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
     * This method returns the username the user looked for
     *
     * @param username, as a string
     * @return an object DBUser
     */
    public static DBUser searchUsername(String username) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM User WHERE username='" + username + "';");
            while (resultset.next()) {
                return new DBUser(resultset.getString("username"), resultset.getString("privilege"), resultset.getString("email"), resultset.getString("first_name"), resultset.getString("second_name"), resultset.getString("image"), resultset.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }

    /**
     * Adds a new user to the database
     *
     * @param user, as an DBUser in the database
     * @return a boolean if it was possible or not
     */
    public static boolean addUserToDatabase(DBUser user) throws UnsupportedEncodingException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
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
    public static boolean editUserInDatase(DBUser user) throws UnsupportedEncodingException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
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

    public static String dateToString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        java.util.Date date = new java.util.Date();
        return dateFormat.format(date);
    }

    public static boolean deleteUserInDatabase(String usname) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
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
    public static DBUser[] getAllUsers() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<DBUser> array = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM User;");
            while (resultset.next()) {
                array.add(new DBUser(resultset.getString("username"), resultset.getString("privilege"), resultset.getString("email"), resultset.getString("first_name"), resultset.getString("second_name"), resultset.getString("image"), resultset.getString("password")));
            }
            return array.toArray(new DBUser[array.size()]);
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
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Material> array = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
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
     * @param id
     * @return
     */
    public static boolean deleteMaterialInDatabase(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            int rowsaffected = statement.executeUpdate("DELETE FROM Material WHERE idMaterial='" + id + "';");
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
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
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
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
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
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
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
    public static Material searchMaterialByID(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Material WHERE idMaterial='" + id + "';");
            while (resultset.next()) {
                return new Material(resultset.getInt("idMaterial"), resultset.getString("name"), resultset.getInt("quantity"), resultset.getFloat("cost"));
            }
            return null;
        } catch (SQLException e) {
            System.out.println(e.getSQLState());
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
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
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
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Client WHERE idClient='" + id + "';");
            while (resultset.next()) {
                return new Cliente(resultset.getInt("idClient"), resultset.getString("first_name"), resultset.getString("second_name"), resultset.getString("address"), resultset.getInt("isPhysical"), resultset.getString("email"));
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
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Client WHERE first_name='" + name + "' OR second_name='" + name + "';");
            while (resultset.next()) {
                return new Cliente(resultset.getInt("idClient"), resultset.getString("first_name"), resultset.getString("second_name"), resultset.getString("address"), resultset.getInt("isPhysical"), resultset.getString("email"));
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
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            int rowsaffected = statement.executeUpdate("INSERT INTO Client(first_name,second_name,address,isPhysical,email) VALUES ('" + cli.getFirst_name() + "' , '" + cli.getSecond_name() + "' , '" + cli.getAddress() + "','" + cli.getIsPhysical() + "' ,'" + cli.getEmail() + "') ;");
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
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
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
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Cliente> array = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Client;");
            while (resultset.next()) {
                array.add(new Cliente(resultset.getInt("idClient"), resultset.getString("first_name"), resultset.getString("second_name"), resultset.getString("address"), resultset.getInt("isPhysical"), resultset.getString("email")));
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
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Order> array = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Pola.Order WHERE client_id= " + Integer.toString(clientID) + ";");
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
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Pola.Order WHERE idOrder= " + orderID + ";");
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
     * @param idNotebook
     * @param idOrder
     * @return
     */
    public static AVOrderNotebook searchNotebookON(String idNotebook, int idOrder) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT Notebook.type,Customization.ribbon,Customization.elastic,Customization.pageType,Customization.image "
                    + "FROM ((Notebook_Order INNER JOIN Notebook ON Notebook_Order.id_Notebook = Notebook.idNotebook) "
                    + "INNER JOIN Customization ON Notebook_Order.id_Customization = Customization.idCustomization) "
                    + "WHERE id_Order = " + idOrder + " AND id_Notebook = " + Integer.parseInt(idNotebook) + "");
            while (resultset.next()) {
                return new AVOrderNotebook(resultset.getString("type"), resultset.getString("ribbon"), resultset.getString("elastic"), resultset.getString("pageType"), resultset.getString("image"));
            }
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }

    public static AVOrderNotebook searchNotebookON(int idOrder) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT Notebook.type,Customization.ribbon,Customization.elastic,Customization.pageType,Customization.image "
                    + "FROM ((Notebook_Order INNER JOIN Notebook ON Notebook_Order.id_Notebook = Notebook.idNotebook) "
                    + "INNER JOIN Customization ON Notebook_Order.id_Customization = Customization.idCustomization) "
                    + "WHERE id_Order = " + idOrder);
            while (resultset.next()) {
                return new AVOrderNotebook(resultset.getString("type"), resultset.getString("ribbon"), resultset.getString("elastic"), resultset.getString("pageType"), resultset.getString("image"));
            }
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }

    /**
     *
     * @return
     */
    public static Notebook[] getAllNotebooks() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Notebook> array = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Notebook;");
            while (resultset.next()) {
                array.add(new Notebook(resultset.getInt("idNotebook"), resultset.getTime("average_time").toString(), resultset.getString("type"), resultset.getFloat("benefit")));
            }
            return array.toArray(new Notebook[array.size()]);
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }

    /**
     *
     * @param ntype
     * @return
     */
    public static Notebook searchNotebookByType(String ntype) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Notebook WHERE type='" + ntype + "';");
            while (resultset.next()) {
                return new Notebook(resultset.getInt("idNotebook"), resultset.getTime("average_time").toString(), resultset.getString("type"), resultset.getFloat("benefit"));
            }
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }

    /**
     *
     * @return
     */
    public static int getLastOrderGenerated() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT MAX(idOrder) FROM Pola.Order;");
            while (resultset.next()) {
                return resultset.getInt("MAX(idOrder)");
            }
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return -1;
    }

    public static Inventory getInventoryByNotebookID(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Inventory WHERE id_Notebook=" + Integer.toString(id) + ";");
            while (resultset.next()) {
                return new Inventory(resultset.getInt("ammount"), resultset.getInt("id_Notebook"));
            }
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }

    public static boolean editInventoryInDatabase(int idNotebook, int ammounty) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            int rowsaffected = statement.executeUpdate(
                    "UPDATE Inventory"
                    + " SET ammount=" + Integer.toString(ammounty)
                    + " WHERE id_Notebook='" + Integer.toString(idNotebook) + "';");
            return rowsaffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getSQLState() + "," + e.getLocalizedMessage()); //Must be a JPopup or something

        }
        return false;
    }

    public static boolean editInventoryInDatabase(Inventory inventory) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            int rowsaffected = statement.executeUpdate(
                    "UPDATE Inventory SET ammount= '" + inventory.getAmmount() + "WHERE Inventory.id_Notebook ='" + inventory.getId_Notebook() + "';");
            return rowsaffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getSQLState() + "," + e.getLocalizedMessage()); //Must be a JPopup or something
        }
        return false;
    }

    public static boolean addNotebookToDatabase(Notebook currentNotebook) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            int rowsaffected = statement.executeUpdate("INSERT INTO Notebook(average_time,type,benefit) VALUES ('" + currentNotebook.getAverage_time() + "' , '" + currentNotebook.getType() + "' , " + currentNotebook.getBenefit() + ") ;");
            return rowsaffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return false;
    }

    public static boolean editNotebookInDatabase(Notebook currentNotebook) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            int rowsaffected = statement.executeUpdate(
                    "UPDATE Notebook"
                    + " SET average_time='" + currentNotebook.getAverage_time() + "',type='" + currentNotebook.getType() + "',benefit=" + currentNotebook.getBenefit()
                    + " WHERE idNotebook=" + Integer.toString(currentNotebook.getId()) + ";");
            return rowsaffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getSQLState() + "," + e.getLocalizedMessage()); //Must be a JPopup or something

        }
        return false;
    }

    public static boolean deleteNotebookInDatabase(String currentNotebook) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            int rowsaffected = statement.executeUpdate("DELETE FROM Notebook WHERE idNotebook=" + currentNotebook + ";");
            return rowsaffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return false;
    }

    //nuevos metodos
    public static Material[] getShortageOfMaterial() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Material> array = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Material WHERE quantity < " + 100 + ";");
            while (resultset.next()) {
                array.add(new Material(resultset.getString("name") + ", ", resultset.getInt("quantity")));
            }
            return array.toArray(new Material[array.size()]);
        } catch (SQLException e) {
        }
        return null;
    }

    public static String[] getShortageOfNotebooks() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> array = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT *"
                    + "FROM Notebook JOIN Inventory ON Notebook.idNotebook = Inventory.id_Notebook "
                    + "WHERE ammount <200;");
            while (resultset.next()) {
                array.add(resultset.getString("type") + ", " + resultset.getInt("ammount"));//+ " "+Integer.toString(resultset.getInt("ammount")));
            }
            return array.toArray(new String[array.size()]);
        } catch (SQLException e) {
        }
        return null;
    }

    public static String[] getOrdersByDate() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> array = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * "
                    + "FROM Pola.Order "
                    + "JOIN Client ON Pola.Order.client_id = Client.idClient ORDER BY date;");
            while (resultset.next()) {
                array.add(resultset.getString("date")
                        + ", " + resultset.getString("priority")
                        + ", " + resultset.getString("first_name")
                        + ", " + resultset.getString("second_name"));
            }
            return array.toArray(new String[array.size()]);
        } catch (SQLException e) {
        }
        return null;
    }

    public static String[] getOrdersByPriority() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> array = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * "
                    + "FROM Pola.Order "
                    + "JOIN Client ON Pola.Order.client_id = Client.idClient ORDER BY priority DESC;");
            while (resultset.next()) {
                array.add(resultset.getString("date")
                        + ", " + resultset.getString("priority")
                        + ", " + resultset.getString("first_name")
                        + ", " + resultset.getString("second_name"));
            }
            return array.toArray(new String[array.size()]);
        } catch (SQLException e) {
        }
        return null;
    }

    public static String[] getMostOrderedNotebooks() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> array = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT idOrder, first_name, second_name, status, priority, quantity "
                    + "FROM Pola.Order "
                    + "JOIN Notebook_Order ON Pola.Order.idOrder = Notebook_Order.id_Order "
                    + "JOIN Client ON Pola.Order.client_id = Client.idClient "
                    + "ORDER BY quantity DESC;");
            while (resultset.next()) {
                array.add(resultset.getString("idOrder") + ", " + resultset.getString("first_name") + ", " + resultset.getString("second_name")
                        + ", " + resultset.getString("status") + ", " + resultset.getString("priority") + ", " + resultset.getString("quantity"));
            }
            return array.toArray(new String[array.size()]);
        } catch (SQLException e) {
        }
        return null;
    }

    public static String[] getMostOrderedNotebooksWithPriority() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> array = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT idOrder, first_name,  second_name, quantity, status, priority  "
                    + "FROM Pola.Order "
                    + "JOIN Notebook_Order ON Pola.Order.idOrder = Notebook_Order.id_Order "
                    + "JOIN Client ON Pola.Order.client_id = Client.idClient "
                    + "ORDER BY priority DESC;");
            while (resultset.next()) {
                array.add(resultset.getString("idOrder") + ", " + resultset.getString("first_name") + ", " + resultset.getString("second_name")
                        + ", " + resultset.getString("quantity") + ", " + resultset.getString("status") + ", " + resultset.getString("priority"));
            }
            return array.toArray(new String[array.size()]);
        } catch (SQLException e) {
        }
        return null;
    }

    public static String[] getMostOrderedNotebooksWithStatus() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> array = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT idOrder, first_name,  second_name, quantity, priority, status "
                    + "FROM Pola.Order "
                    + "JOIN Notebook_Order ON Pola.Order.idOrder = Notebook_Order.id_Order "
                    + "JOIN Client ON Pola.Order.client_id = Client.idClient "
                    + "ORDER BY status DESC;");
            while (resultset.next()) {
                array.add(resultset.getString("idOrder") + ", " + resultset.getString("first_name") + ", " + resultset.getString("second_name")
                        + ", " + resultset.getString("quantity") + ", " + resultset.getString("priority") + ", " + resultset.getString("status"));
            }
            return array.toArray(new String[array.size()]);
        } catch (SQLException e) {
        }
        return null;
    }

    public static String[] getOrdersUnfinished() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }

        ArrayList<String> array = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT Pola.Order.idOrder,Pola.Order.client_id, status, first_name, second_name "
                    + "FROM Notebook_Order "
                    + "JOIN Pola.Order ON Notebook_Order.id_Order=Pola.Order.idOrder "
                    + "JOIN Client ON Pola.Order.client_id = Client.idClient "
                    + "WHERE status!='Entrega';");
            while (resultset.next()) {
                array.add(Integer.toString(resultset.getInt("client_id")) + ", "
                        + (resultset.getString("first_name") + ", ")
                        + (resultset.getString("second_name") + ", ")
                        + (resultset.getString("status")));
            }
            return array.toArray(new String[array.size()]);
        } catch (SQLException e) {
            System.out.println("Error " + e.getSQLState());
        }
        return null;
    }

    public static String[] getOrdersBetweenDates(String date1, String date2) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> array = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT type, benefit*quantity "
                    + "FROM Pola.Notebook_Order "
                    + "JOIN Notebook ON Notebook_Order.id_Notebook = Notebook.idNotebook "
                    + "JOIN Pola.Order ON Notebook_Order.id_Order = Pola.Order.idOrder "
                    + "WHERE Pola.Order.date >= '" + date1 + "' AND Pola.Order.date <= '" + date2 + "';");
            while (resultset.next()) {
                array.add(resultset.getString("type"));
                array.add(resultset.getString("benefit*quantity"));
            }
            return array.toArray(new String[array.size()]);
        } catch (SQLException e) {
        }
        return null;
    }

    public static String[] getDistinctTypeOfNotebooks() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<String> array = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("select distinct(type) "
                    + "FROM Notebook_Order "
                    + "JOIN Notebook ON Notebook_Order.id_Notebook = Notebook.idNotebook "
                    + "JOIN Pola.Order ON Notebook_Order.id_Order = Pola.Order.idOrder;");
            while (resultset.next()) {
                array.add(resultset.getString("type"));
            }
            return array.toArray(new String[array.size()]);
        } catch (SQLException e) {

        }
        return null;
    }

    public static Order[] getCompleteOrdersByDate(String date1, String date2) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<Order> array = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Pola.Order WHERE date "
                    + "BETWEEN '" + date1 + "' AND '" + date2 + "';");
            while (resultset.next()) {
                array.add(new Order(resultset.getInt("idOrder"), resultset.getDate("date").toString(), resultset.getString("priority"), resultset.getDate("create_time").toString(), resultset.getInt("client_id")));
            }
            return array.toArray(new Order[array.size()]);
        } catch (SQLException e) {
        }
        return null;
    }

    public static String getOldestUser() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT username,MIN(create_time) FROM User GROUP BY username DESC;");
            while (resultset.next()) {
                return resultset.getString("username");
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public static String getNumberOfWorkers() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT count(username) FROM User WHERE privilege='worker' ;");
            while (resultset.next()) {
                return resultset.getString("count(username)");
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public static String getNumberOfImageOrders() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT COUNT(id_Order) FROM Notebook_Order JOIN Customization ON Notebook_Order.id_Customization = Customization.idCustomization WHERE image IS NOT NULL;");
            while (resultset.next()) {
                return Integer.toString(resultset.getInt("COUNT(id_Order)"));
            }
        } catch (SQLException e) {
        }
        return null;
    }

    public static void addAllNotebookMaterials(NotebookMaterial get) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            int rowsaffected = statement.executeUpdate("INSERT INTO Notebook_Material VALUES (" + get.getNotebook_id() + " , " + get.getMaterial_id() + " , " + get.getAmmount() + ") ;");
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
    }

    public static DBUser getUserData(String username) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM User WHERE username='" + username + "';");
            //if there is no data on the data set, the session return will be false
            while (resultset.next()) {
                return new DBUser(resultset.getString("username"), resultset.getString("privilege"), resultset.getString("email"), resultset.getString("first_name"), resultset.getString("second_name"), resultset.getString("image"), resultset.getString("password"));
            }//return session;
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }

    public static void updateClientInDatabase(Cliente client) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        int count = 0;
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE Client "
                    + "SET first_name='" + client.getFirst_name() + "', second_name='" + client.getSecond_name() + "', address='" + client.getAddress() + "', isPhysical=" + client.getIsPhysical() + ", email='" + client.getEmail() + "' "
                    + "WHERE idClient=" + client.getId() + ";");
            //if there is no data on the data set, the session return will be false

        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
    }

    public static boolean userExists(String username) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        int count = 0;
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT username FROM User WHERE username='" + username + "' ;");
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

    public static Notebook searchNotebookByID(int notebookID) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Notebook WHERE idNotebook=" + notebookID + " ;");
            //if there is no data on the data set, the session return will be false
            while (resultset.next()) {
                return new Notebook(resultset.getInt("idNotebook"), resultset.getTime("average_time").toString(), resultset.getString("type"), resultset.getFloat("benefit"));
            }
            statement.close();
            connection.close();
            //return session;
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }

    public static NotebookMaterial[] getMaterialsofNotebook(int notebookID) {
        ArrayList<NotebookMaterial> on = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Notebook_Material WHERE notebook_id=" + notebookID + ";");
            //if there is no data on the data set, the session return will be false
            while (resultset.next()) {
                on.add(new NotebookMaterial(resultset.getInt("notebook_id"), resultset.getInt("material_id"), resultset.getInt("ammount")));
            }
            statement.close();
            connection.close();
            //return session;
            return on.toArray(new NotebookMaterial[on.size()]);
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }

    public static OrderNotebooks[] getAllNotebooksFromOrders(int orderID) {
        ArrayList<OrderNotebooks> on = new ArrayList<>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Notebook_Order where id_Order=" + orderID + ";");
            //if there is no data on the data set, the session return will be false
            while (resultset.next()) {
                on.add(new OrderNotebooks(resultset.getInt("id_Notebook"), resultset.getInt("id_Order"), resultset.getInt("quantity"), resultset.getString("status"), resultset.getString("ribbon"), resultset.getString("image"), resultset.getString("elastic"), resultset.getString("pageType")));
            }
            statement.close();
            connection.close();
            return on.toArray(new OrderNotebooks[on.size()]);
            //return session;
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }

    public static void DeleteNotebookOrderInDatabase(String orderID, String notebookID) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            int rowsaffected = statement.executeUpdate("DELETE FROM Notebook_Order WHERE id_Order=" + Integer.parseInt(orderID) + " AND id_Notebook=" + Integer.parseInt(notebookID) + ";");
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
    }

    public static boolean deleteOrder(int orderid) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            int rowsaffected = statement.executeUpdate("DELETE FROM Pola.Order WHERE idOrder=" + Integer.toString(orderid) + ";");
            return rowsaffected > 0;
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return false;
    }

    public static void editOrderInDatabase(Order order) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE Pola.Order "
                    + "SET date='" + order.getDate() + "', priority='" + order.getPriority() + "', create_time='" + order.getCreate_time() + "'  "
                    + "WHERE idOrder=" + order.getId() + ";");
            //if there is no data on the data set, the session return will be false

        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
    }

    public static void addOrderToDatabase(Order ord) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            int rowsaffected = statement.executeUpdate("INSERT INTO Pola.Order(date,priority,create_time,client_id) VALUES ('" + ord.getDate() + "' , '" + ord.getPriority() + "' , '" + dateToString() + "', " + ord.getClient_id() + ") ;");
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
    }

    public static OrderNotebooks getNotebookOrder(String orderID, String notebookID) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Notebook_Order where id_Order=" + orderID + " AND id_Notebook=" + notebookID + ";");
            //if there is no data on the data set, the session return will be false
            while (resultset.next()) {
                return new OrderNotebooks(resultset.getInt("id_Notebook"), resultset.getInt("id_Order"), resultset.getInt("quantity"), resultset.getString("status"), resultset.getString("ribbon"), resultset.getString("image"), resultset.getString("elastic"), resultset.getString("pageType"));
            }
            statement.close();
            connection.close();
            //return session;
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }

    public static void editNotebookOrder(OrderNotebooks on) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE Notebook_Order "
                    + "SET quantity=" + on.getQuantity() + ", status='" + on.getStatus() + "', ribbon='" + on.getRibbon() + "', image='" + on.getImage() + "', pageType='" + on.getPageType() + "'  "
                    + "WHERE id_Order=" + on.getId_Order() + " AND id_Notebook=" + on.getId_Notebook() + ";");
            //if there is no data on the data set, the session return will be false

        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }

    }

    public static void addNotebookOrder(OrderNotebooks on) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            int rowsaffected = statement.executeUpdate("INSERT INTO Notebook_Order(id_Notebook,id_Order,quantity,status,ribbon,image,elastic,pageType) "
                    + "VALUES (" + on.getId_Notebook() + " , " + on.getId_Order() + " , " + on.getQuantity() + ",'" + on.getStatus() + "','" + on.getRibbon() + "', '" + on.getImage() + "','" + on.getElastic() + "','" + on.getPageType() + "' ) ;");
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
    }

    public static HighestBenefitCC[] getHighestBenefitBetweenDates(String date1, String date2) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList<HighestBenefitCC> array = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT type, SUM(benefit * quantity) "
                    + "FROM Notebook_Order JOIN Notebook ON Notebook_Order.id_Notebook = Notebook.idNotebook "
                    + "JOIN Pola.Order ON Notebook_Order.id_Order = Pola.Order.idOrder "
                    + "WHERE Pola.Order.date >= '" + date1 + "' AND Pola.Order.date <= '" + date2 + "'"
                    + " GROUP BY (type) ORDER BY (SUM(benefit*quantity)) DESC;");
            while (resultset.next()) {
                array.add(new HighestBenefitCC(resultset.getString("type"), resultset.getInt("SUM(benefit * quantity)")));
            }
            return array.toArray(new HighestBenefitCC[array.size()]);
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }

    public static String getMaterialName(int id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT name FROM Material WHERE idMaterial='" + id + "';");
            while (resultset.next()) {
                return resultset.getString("name");
            }
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }

    public static void deleteNotebookMaterial(int materialID, int notebookID) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            int rowsaffected = statement.executeUpdate("DELETE FROM Notebook_Material WHERE notebook_id=" + notebookID + " AND material_id=" + materialID + ";");
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
    }

    public static NotebookMaterial searchMaterialNotebook(int notebookID, int materialID) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM Notebook_Material WHERE notebook_id=" + notebookID + " AND material_id=" + materialID + ";");
            //if there is no data on the data set, the session return will be false
            while (resultset.next()) {
                return new NotebookMaterial(resultset.getInt("notebook_id"), resultset.getInt("material_id"), resultset.getInt("ammount"));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return null;
    }

    public static void updateNotebookMaterial(int notebookID, int materialID, int quantity) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            int rowsaffected = statement.executeUpdate("UPDATE Notebook_Material SET notebook_id=" + notebookID + " , material_id=" + materialID + " , ammount=" + quantity + " WHERE notebook_id=" + notebookID + " AND material_id=" + materialID + ";");
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
    }

    public static void addNotebookMaterial(int notebookID, int materialID, int quantity) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            int rowsaffected = statement.executeUpdate("INSERT INTO Notebook_Material VALUES (" + notebookID + " , " + materialID + " , " + quantity + ") ;");
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
    }

    public static void substractAllRelatedMaterials(String id_Notebook) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        //We first get all related materials to the notebook
        NotebookMaterial[] nm = getMaterialsofNotebook(Integer.parseInt(id_Notebook));
        for (int i = 0; i < nm.length; i++) {
            Connection connection;
            try {
                connection = DriverManager.getConnection(host, huser, hpassword);
                Statement statement = connection.createStatement();
                int rowsaffected = statement.executeUpdate("UPDATE Material SET quantity=quantity-" + nm[i].getAmmount() + " WHERE idMaterial=" + nm[i].getMaterial_id() + ";");
            } catch (SQLException ex) {
                Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public static void substractAllRelatedNotebooks(String id_Notebook, String quantity) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }

        Connection connection;
        try {
            connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE Inventory SET ammount=ammount-" + quantity + " WHERE id_Notebook=" + id_Notebook + ";");
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static int getAmmountOfNotebooksInOrder(String idOrder, String id_Notebook) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            ResultSet resultset = statement.executeQuery("SELECT quantity FROM Notebook_Order WHERE id_Notebook=" + id_Notebook + " AND id_Order=" + idOrder + ";");
            //if there is no data on the data set, the session return will be false
            while (resultset.next()) {
                return resultset.getInt("quantity");
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getSQLState()); //Must be a JPopup or something
        }
        return -1;
    }

    public static void addAllRelatedMaterials(String id_Notebook) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            //We first get all related materials to the notebook
            Connection connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            NotebookMaterial[] nm = getMaterialsofNotebook(Integer.parseInt(id_Notebook));
            for (int i = 0; i < nm.length; i++) {
                statement.executeUpdate("UPDATE Notebook_Material SET ammount=ammount+" + nm[i].getAmmount() + " WHERE material_id=" + nm[i].getMaterial_id() + ";");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);

        }
    }

    public static void addAllRelatedNotebooks(String id_Notebook, String quantity) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }

        Connection connection;
        try {
            connection = DriverManager.getConnection(host, huser, hpassword);
            Statement statement = connection.createStatement();
            statement.executeUpdate("UPDATE Inventory SET ammount=ammount+" + quantity + " WHERE id_Notebook=" + id_Notebook + ";");
        } catch (SQLException ex) {
            Logger.getLogger(Handler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
