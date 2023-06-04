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

    /**
     * Getter for type of drink
     * @return
     */
    @Override
    public String getType()
    {
        return "Mocha";
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
     * getter for caloreis
     * @return total calories
     */
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
