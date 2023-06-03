package com.example.helloworld;

import java.util.ArrayList;
import java.util.HashMap;

public class coffeeDrink
{
    public double price = 0;
    public int calories = 0;
    public String drinkType;
    private HashMap<String,Integer> properties = new HashMap<>();
    private ArrayList<additions> additions = new ArrayList<additions>();

    /**
     * This is the coffeeDrink constructor
     * @param drinkType
     * @param price
     * @param calories
     *
     * @param calories
     */
    public coffeeDrink(String drinkType, double price, int calories, HashMap properties, ArrayList additions)
    {
        this.drinkType = drinkType;
        this.price = price;
        this.calories = calories;
        this.properties = properties;
        this.additions = additions;
    }

    /**
     * This gets the price of the drink
     * @return The price of the drink
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * This returns the amount of calories in a drink
     * @return the amount of calories
     */
    public int getCalories()
    {
        return calories;
    }
    public HashMap getProperties(){return properties;}

    public String getDrinkType(){return drinkType;}
    public ArrayList<additions> getAdditions(){return this.additions;}



    public double getTotalPrice()
    {
        double totalPrice = this.price;
        for (additions add : additions) {
            totalPrice += add.getPrice();
        }
        return totalPrice;
    }

    /**
     * This gets the total calories of a drink + additions
     * @return Int total calories
     */
    public int getTotalCalories()
    {
        int totalCalories = this.calories;
        for (additions add : additions)
        {
            totalCalories += add.getCalories();
        }
        return totalCalories;
    }
}
