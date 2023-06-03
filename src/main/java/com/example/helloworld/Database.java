package com.example.helloworld;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Database {

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
     */
    public void addOrder(int drinkNumber, int customerID, String orderDate, String drinkType, double price, int calories, String additions)
    {
        String query = "INSERT INTO orders " + "VALUES(" + drinkNumber + ", '" + customerID + "', '" + orderDate + "', '" + drinkType + "', " + price + ", " + calories + ", '" + additions + "')" ;
        this.executeQuery(query);

    }
    /**
     * Adds a drink to the drinks table
     * @param orderID The number of the order
     * @param drinkNumber for this order (Order 1 Drink 1, Order 1 Drink 2, etc...)
     * @param drinkType Enumerated variables|
     * @param size 							|
     * @param caffeine  					|
     * @param temp                          |
     * @param milk Boolean variables(0 for no, 1 for yes)
     * @param syrup                                     |
     * @param whippedCream				                |
     * @param sugar                                     |
     * @param price	as a double with two significant digits
     * @param calories
     */
    public void addDrink(int orderID, int drinkNumber, String drinkType, Enums.Size size, Enums.Caffeine caffeine, Enums.Temperature temp,  int milk, int syrup, int whippedCream, int sugar, double price, int calories)
    {
        String query = "INSERT INTO drinks " + "VALUES(" + orderID +  "', " + drinkNumber + ", '" + drinkType + "', '"
                + size + "', '" + caffeine + "', '" + temp + "', '" + milk + "', '" + syrup + "', "
                + whippedCream + ", " + sugar + ", " + price + ", " + calories + ")";
        this.executeQuery(query);
    }

    public void executeQuery(String query) {
        try {
            Connection con = DriverManager.getConnection(this.url, this.username, this.password);
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(query);
        }
        catch(SQLException a) {
            System.out.println("Error! " + a);
        }
    }

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
