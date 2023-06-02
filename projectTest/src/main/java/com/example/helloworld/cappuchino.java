package com.example.helloworld;

public class cappuchino extends coffeeDrink
{
    /**
     * Contructor for making a Cappuchino
     */
    public cappuchino(boolean hasMilk, boolean hasSugar, boolean hasSyrup, boolean hasWhippedCream)
    {
        super(6.75, 780,hasMilk, hasSugar, hasSyrup, hasWhippedCream);
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
    public String getType() 
    {
        return "Cappuchino";
    }
    @Override
    public String toString()
    {
        return super.toString();
    }
}
