package coffeeshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Print {

	/**
	 * Prints out all of the rows contained in the accounts table
	 */
	public static void printAccounts() {
		try {
			Connection con = DriverManager.getConnection(CoffeeShop.url, CoffeeShop.username, CoffeeShop.password);
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM accounts");
			String r = "";
			while(result.next()) {
				r += result.getString("userID") + " " + 
					result.getString("password") + " " + 
					result.getString("username") + " " +
					result.getString("numOrders") + "\n";
			}
			System.out.println(r);
		}
		catch(SQLException a) {
			System.out.println("Error! " + a);
		}
	}
	
	/**
	 * Prints out all of the rows contained in the drinks table
	 */
	public static void printDrinks() {
		try {
			Connection con = DriverManager.getConnection(CoffeeShop.url, CoffeeShop.username, CoffeeShop.password);
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM drinks");
			String r = "";
			while(result.next()) {
				r += result.getString("orderID") + " " + 
					result.getString("orderDate") + " " + 
					result.getString("drinkNumber") + " " +
					result.getString("drinkType") + " " +
					result.getString("size") + " " +
					result.getString("temperature") + " " +
					result.getString("syrup") + " " +
					result.getString("milk") + " " +
					result.getString("caffeine") + " " +
					result.getString("whippedCream") + " " +
					result.getString("quantity") + " " +
					result.getString("price") + " " +
					result.getString("calories") + " " +
					result.getString("specialInstructions") + "\n";
			}
			System.out.println(r);
		}
		catch(SQLException a) {
			System.out.println("Error! " + a);
		}
	}
	
	/**
	 * Prints out all of the rows contained in the orders table
	 */
	public static void printOrders() {
		try {
			Connection con = DriverManager.getConnection(CoffeeShop.url, CoffeeShop.username, CoffeeShop.password);
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM orders");
			String r = "";
			while(result.next()) {
				r += result.getString("orderNumber") + " " + 
					result.getString("orderDate") + " " + 
					result.getString("customerID") + " " +
					result.getString("totalCost") + "\n";
			}
			System.out.println(r);
		}
		catch(SQLException a) {
			System.out.println("Error! " + a);
		}
	}
}