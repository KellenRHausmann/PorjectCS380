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

    /**
     * getter for price
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
     * getter for type of drink
     * @return name of drink
     */
    @Override
    public String getType() 
    {
        return "Americano";
    }
    /**
     * toString method
     * @return string
     */
    @Override
    public String toString()
    {
        return super.toString();
    }
}
