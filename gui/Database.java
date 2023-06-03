package com.example.helloworld;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Database {

    public static String url = "jdbc:mysql://localhost:3306/coffeeshop";
    public static String username = "root";
    public static String password = "";

    /**
     * Adds a user to the accounts table userID is auto-incrementing. DEFAULT numOrders value is 0.
     * @param password The account password
     * @param userName The user's username
     */
    public static void addUser(String password, String userName) {
        String query = "INSERT INTO accounts(pass, username)"
                + "VALUES('" + password + "', '" + userName + "')";
        Database.executeQuery(query);
    }

    /**
     * Adds an order to the orders table.
     * @param orderNumber
     * @param date LIKE THIS "YYYY-MM-DD"
     * @param customerID
     * @param totalCost starts at 0.00
     */
    public static void addOrder(int orderNumber, String date, int customerID, double totalCost) {
        String query = "INSERT INTO orders "
                + "VALUES(" + orderNumber + ", '" + date + "', " + customerID + ", " + totalCost + ")";
        Database.executeQuery(query);
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
    public static void addDrink(int orderID, int drinkNumber, Enums.Type drinkType, Enums.Size size,
                                Enums.Caffeine caffeine, Enums.Temperature temp,  int milk, int syrup,
                                int whippedCream, int sugar, double price, int calories) {
        String query = "INSERT INTO drinks "
                + "VALUES(" + orderID +  "', " + drinkNumber + ", '" + drinkType + "', '"
                + size + "', '" + caffeine + "', '" + temp + "', '" + milk + "', '" + syrup + "', "
                + whippedCream + ", " + sugar + ", " + price + ", " + calories + ")";
        Database.executeQuery(query);
    }

    public static void executeQuery(String query) {
        try {
            Connection con = DriverManager.getConnection(CoffeeShop.url, CoffeeShop.username, CoffeeShop.password);
            Statement statement = con.createStatement();
            int result = statement.executeUpdate(query);
        }
        catch(SQLException a) {
            System.out.println("Error! " + a);
        }
    }
}
