package coffeeshop;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CoffeeShop {

	//url, username, and password for MySQL. Fill in password field
	public static String url = "jdbc:mysql://localhost:3306/coffeeshop";
	public static String username = "root";
	public static String password = "";
	
	public static void main(String[] args) throws SQLException{
		
		//Adds a user with some ID number and default number of orders, 0
		String password = "password";
		String userName = "JohnDoe";
		Add.addUser(password, userName);
		
		Print.printAccounts();
		
		//Adds an order (order number, date, userID, total cost at 0.00 before updating)
		Add.addOrder(1, "2023-05-19", 7 , 0);
		
		Print.printOrders();
		
		//Adds drinks to an order
		//(orderID, date, drinkID, Type, Size, Temperature, Syrup, Milk, Caffeine, 
		//whippedCream, quantity, price, calories, specialInstructions)
		Add.addDrink(1, "2023-05-19", 1, Enums.Type.MOCHA, Enums.Size.LARGE, 
				Enums.Temperature.HOT, Enums.Syrup.CARAMEL, Enums.Milk.REGULAR, 
				Enums.Caffeine.DECAF, 1, 1, 3.75, 285, null);
		Add.addDrink(1, "2023-05-19", 2, Enums.Type.CAPPUCCINO , Enums.Size.SMALL, 
				Enums.Temperature.ICED, Enums.Syrup.NONE, Enums.Milk.ALMOND, 
				Enums.Caffeine.REGULAR, 0, 1, 2.50, 195, "Draw a leaf");
		
		Print.printDrinks();
		
		//Updates order price of order 1
		Update.updateOrderPrice(1);
		
		Print.printOrders();
		
		//Updates the number of orders of customer with userID 7
		Update.updateCustomerOrders(7);
		
		Print.printAccounts();
	}
	
	/**
	 * Generic execute query method. Used for updating and adding rows into a database table.
	 * @param query A String that contains SQL instructions
	 */
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
