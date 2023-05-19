package coffeeshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Update {

	/**
	 * Updates the total cost of an order by aggregating the prices of all of the order's drinks.
	 * Calls the calculatePrice method to aggregate drink prices.
	 * @param orderID the order number to calculate the price of
	 */
	public static void updateOrderPrice(int orderID){
		String query = "SELECT orderID, "
				+ "SUM(price) AS total_price "
				+ "FROM drinks "
				+ "WHERE orderID = " + orderID + " "
				+ "GROUP BY orderID";
		double tc = calculatePrice(query);
		
		//Update the order with the total cost
		query = "UPDATE orders SET totalCost = " + tc + " "
				+ "WHERE orderNumber = " + orderID;
		CoffeeShop.executeQuery(query);
	}
	
	/**
	 * Updates the number of orders a customer has placed by counting the number of orders associated with their userID.
	 * Calls the getOrders method to count orders.
	 * @param userID the userID of the user to count the orders of
	 */
	public static void updateCustomerOrders(int userID) {
		String query = "SELECT customerID, "
				+ "COUNT(*) AS numOrders "
				+ "FROM orders "
				+ "WHERE customerID = " + userID + " "
				+ "GROUP BY orderNumber";
		int no = getOrders(query);
		
		query = "UPDATE accounts "
				+ "SET numOrders = " + no + " "
				+ "WHERE userID = " + userID;
		CoffeeShop.executeQuery(query);
	}
	
	/**
	 * Calculates the price of all of an order's drinks and returns the total
	 * @param query a SQL query passed by the upDateOrderPrice method
	 * @return a double value as a price
	 */
	public static double calculatePrice(String query) {
		try {
			Connection con = DriverManager.getConnection(CoffeeShop.url, CoffeeShop.username, CoffeeShop.password);
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			result.next();
			
			return result.getDouble("total_price");
		}
		catch(SQLException a) {
			System.out.println("Error! " + a);
			return 0;
		}
	}
	
	/**
	 * Returns the number of orders associated with a UserID
	 * @param query the SQL query passed by the updateCustomerOrders method
	 * @return an int value as the total number of orders
	 */
	public static int getOrders(String query) {
		try {
			Connection con = DriverManager.getConnection(CoffeeShop.url, CoffeeShop.username, CoffeeShop.password);
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery(query);
			result.next();
			
			return result.getInt("numOrders");
		}
		catch(SQLException a) {
			System.out.println("Error! " + a);
			return 0;
		}
	}
}
