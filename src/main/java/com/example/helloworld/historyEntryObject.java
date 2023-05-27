package com.example.helloworld;

/**
 * Class that represents an Order entry as a single object
 * Used to create javafx TableView more easily
 */

public class historyEntryObject {
    // the date and cost of item from hashmap
    private final String date;
    private final String drinkType;
    private double price;
    private int calories;

    public historyEntryObject(String date, String drinkType, Double price, Integer calories)
    {
        this.date = date;
        this.drinkType = drinkType;
        this.price = price;
        this.calories = calories;
    }

    public String getDate() {
        return date;
    }

    public String getDrinkType() {
        return drinkType;
    }
    public double getPrice() {
        return price;
    }
    public int getCalories(){
        return calories;
    }

}
