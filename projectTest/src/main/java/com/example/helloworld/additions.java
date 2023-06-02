package com.example.helloworld;

public class additions
{
    /**
     * Additions for the drinks
     */
    public static final additions milk  = new additions(0.25, 25, "milk");
    public static final additions sugar = new additions(0.50, 15, "sugar");
    public static final additions syrup = new additions(1.25, 50, "syrup");
    public static final additions whipCream = new additions(0.80, 75, "whipped cream");

    private double price;
    private int calories;
    private String name;

    /**
     * contructor for additions
     * @param price
     * @param calories
     * @param name
     */
    public additions(double price, int calories, String name)
    {
        this.price = price;
        this.calories = calories;
        this.name = name;
    }

    /**
     * gets the price
     * @return
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * gets the calories
     * @return
     */
    public int getCalories()
    {
        return calories;
    }

    /**
     * gets the name of the addition
     * @return
     */
    public String getName()
    {
        return name;
    }
}
