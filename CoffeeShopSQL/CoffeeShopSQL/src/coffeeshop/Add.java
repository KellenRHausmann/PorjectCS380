package coffeeshop;

public class Add {

	/**
	 * Adds a user to the accounts table userID is auto-incrementing. DEFAULT numOrders value is 0.
	 * @param password The account password
	 * @param userName The user's username
	 */
	public static void addUser(String password, String userName) {
		String query = "INSERT INTO accounts(password, username, numOrders) "
				+ "VALUES('" + password + "', '" + userName + "', DEFAULT)";
		CoffeeShop.executeQuery(query);
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
		CoffeeShop.executeQuery(query);
	}
	/**
	 * Adds a drink to the drinks table
	 * @param orderID The number of the order
	 * @param date LIKE THIS "YYYY-MM-DD"
	 * @param drinkNumber for this order (Order 1 Drink 1, Order 1 Drink 2, etc...)
	 * @param drinkType Enumerated variables|
	 * @param size 							|
	 * @param temp 							|
	 * @param syrup 						|
	 * @param milk 							|
	 * @param caffeine 						|
	 * @param whippedCream 0 for no, 1 for yes			
	 * @param quantity
	 * @param price	as a double with two significant digits
	 * @param calories
	 * @param specialInstructions max 255 characters
	 */
	public static void addDrink(int orderID, String date, int drinkNumber, Enums.Type drinkType, 
			Enums.Size size, Enums.Temperature temp, Enums.Syrup syrup, Enums.Milk milk, Enums.Caffeine caffeine, 
			int whippedCream, int quantity, double price, int calories, String specialInstructions) {
		String query = "INSERT INTO drinks "
				+ "VALUES(" + orderID + ", '" + date + "', " + drinkNumber + ", '" + drinkType + "', '" 
				+ size + "', '" + temp + "', '" + syrup + "', '" + milk + "', '" + caffeine + "', "
				+ whippedCream + ", " + quantity + ", " + price + ", " + calories + ", '" + specialInstructions + "')";
		CoffeeShop.executeQuery(query);
	}
}
