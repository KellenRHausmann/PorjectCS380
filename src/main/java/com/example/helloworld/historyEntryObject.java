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

    public String getDate() {
        return date;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public String getAdds()
    {
        return adds;
    }

    public String getCaffeine()
    {
        return caffeine;
    }

    public String getSize()
    {
        return size;
    }

    public String getTemp()
    {
        return temp;
    }

    public double getPrice() {
        return price;
    }
    public int getCalories(){
        return calories;
    }

}
