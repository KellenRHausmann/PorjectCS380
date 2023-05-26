package com.example.helloworld;

public class americano extends coffeeDrink
{
    /**
     * Contructor for making a americano
     */
    public americano(boolean hasMilk, boolean hasSugar, boolean hasSyrup, boolean hasWhippedCream)
    {
        super(2.00, 100,hasMilk, hasSugar, hasSyrup, hasWhippedCream);
    }

    public double getPrice() 
    {
        return (price + super.getPrice());
    }

    public int getCalories() 
    {
        return (calories + super.getCalories());
    }

    @Override
    public String getType() 
    {
        return "Americano";
    }
    @Override
    public String toString()
    {
        return super.toString();
    }
}
