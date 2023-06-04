package com.example.helloworld;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Database
{

    public static String url = "jdbc:mysql://localhost:3306/projectdatabase";
    public static String username = "root";
    public static String password = "cs380";

    /**
     * Adds a user to the accounts table userID is auto-incrementing. DEFAULT numOrders value is 0.
     * @param password The account password
     * @param userName The user's username
     */
    public void addUser(String password, String userName)
    {
        String query = "INSERT INTO accounts(pass, username)" + "VALUES('" + password + "', '" + userName + "')";
        this.executeQuery(query);
    }

    /**
     * Adds an order to the orders table.
     * @param drinkNumber
     * @param orderDate LIKE THIS "YYYY-MM-DD"
     * @param customerID
     * @param price starts at 0.00
     * @param calories
     * @param additions
     * @param size
     * @param temperature
     * @param caffeine
     */
    public void addOrder(int drinkNumber, int customerID, String orderDate, String drinkType, double price, int calories, String additions, String size, String temperature, String caffeine)
    {
        String query = "INSERT INTO orders " + "VALUES(" + drinkNumber + ", '" + customerID + "', '" + orderDate + "', '" +
                drinkType + "', " + price + ", " + calories + ", '" + additions + "', '" + size + "', '" + temperature + "', '" + caffeine + "')";
        this.executeQuery(query);

    }

    /**
     * Executes a query
     * @param query
     */
    public void executeQuery(String query)
    {
        try
        {
            Connection con = DriverManager.getConnection(this.url, this.username, this.password);
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(query);
        }
        catch(SQLException a)
        {
            System.out.println("Error! " + a);
        }
    }

    /**
     * Gets the max drink number to interate to when adding to the databse
     * @return int returnCount
     * @throws SQLException
     */
    public int getMaxDrinkCount() throws SQLException
    {
        int returnCount = 0;
        String query = "SELECT MAX(drinkNumber) FROM orders";
        Connection con = DriverManager.getConnection(url, username, password);
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(query);

        if(result.next())
        {
            int maxCount = result.getInt(1);
            returnCount = maxCount + 1;
        }

        return returnCount;
    }

    /**
     * Validates a user
     * @param query
     * @return an id number
     */
    public int validateUser(String query){
        try
        {
            Connection con = DriverManager.getConnection(this.url, this.username, this.password);
            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(query);
            result.next();
            try
            {
                int id = result.getInt("userID");
                return id;
            }
            catch(SQLException a){
                return 0;
            }
        }
        catch(SQLException a) {
            System.out.println("Error! " + a);
        }
        return 0;
    }
}
