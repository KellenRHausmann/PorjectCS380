package com.example.helloworld;

public class cappuccino extends coffeeDrink
{
    /**
     * Contructor for making a Cappuchino
     */
    public cappuccino(boolean hasMilk, boolean hasSugar, boolean hasSyrup, boolean hasWhippedCream)
    {
        super(6.75, 780,hasMilk, hasSugar, hasSyrup, hasWhippedCream);
    }

    /**
     * Getter for price
     * @return total price
     */
    public double getPrice() 
    {
        return (price + super.getPrice());
    }

    /**
     * getter for calories
     * @return total calories
     */
    public int getCalories() 
    {
        return (calories + super.getCalories());
    }

    /**
     * This is the toString method
     * @return type of drink
     */
    @Override
    public String getType() 
    {
        return "Cappuchino";
    }

    /**
     * To string method
     * @return string
     */
    @Override
    public String toString()
    {
        return super.toString();
    }
}
