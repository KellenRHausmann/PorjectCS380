package com.example.helloworld;

/**
 * Class that represents an Order entry as a single object
 * Used to create javafx TableView more easily
 */

public class historyEntryObject
{
    private final String date;
    private final String drinkType;
    private final String size;
    private final String temp;
    private final String caffeine;
    private final String adds;
    private double price;
    private int calories;

    /**
     * Constructor for the historyEntryObject
     * @param date
     * @param drinkType
     * @param price
     * @param calories
     * @param adds
     * @param size
     * @param temp
     * @param caffeine
     */
    public historyEntryObject(String date, String drinkType, Double price, Integer calories, String adds, String size, String temp, String caffeine)
    {
        this.date = date;
        this.drinkType = drinkType;
        this.price = price;
        this.calories = calories;
        this.adds = adds;
        this.size = size;
        this.temp = temp;
        this.caffeine = caffeine;
    }

    /**
     * Getter method for date
     * @return
     */
    public String getDate() {
        return date;
    }
    /**
     * Getter method for drink type
     * @return
     */
    public String getDrinkType() {
        return drinkType;
    }
    /**
     * Getter method for additions
     * @return
     */
    public String getAdds()
    {
        return adds;
    }
    /**
     * Getter method for caffeine
     * @return
     */
    public String getCaffeine()
    {
        return caffeine;
    }
    /**
     * Getter method for size
     * @return
     */
    public String getSize()
    {
        return size;
    }
    /**
     * Getter method for temp
     * @return
     */
    public String getTemp()
    {
        return temp;
    }
    /**
     * Getter method for price
     * @return
     */
    public double getPrice() {
        return price;
    }
    /**
     * Getter method for calories
     * @return
     */
    public int getCalories(){
        return calories;
    }

}
