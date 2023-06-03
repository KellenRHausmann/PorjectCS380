package com.example.helloworld;

public class mocha extends coffeeDrink
{
    /**
     * Contructor for making a mocha
     */
    public mocha(boolean hasMilk, boolean hasSugar, boolean hasSyrup, boolean hasWhippedCream)
    {
        super(5.50, 400, hasMilk, hasSugar, hasSyrup, hasWhippedCream);
    }

    @Override
    public String getType()
    {
        return "Mocha";
    }

    public double getPrice() 
    {
        return (price + super.getPrice());
    }

    public int getCalories() 
    {
        return (calories + super.getCalories());
    }

    /**
     * This is the toString method
     * @return
     */
    @Override
    public String toString()
    {
        return super.toString();
    }
}
