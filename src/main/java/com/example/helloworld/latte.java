package com.example.helloworld;

public class latte extends coffeeDrink
{
        /**
         * Contructor for making a latte
         */
        public latte(boolean hasMilk, boolean hasSugar, boolean hasSyrup, boolean hasWhippedCream)
        {
            super(4.25, 250,hasMilk, hasSugar, hasSyrup, hasWhippedCream);
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
     * getter for type of drink
     * @return type of drink
     */
        @Override
        public String getType() 
        {
            return "Latte";

        }
        /**
         * This is the toString method
         * @return string
         */
        @Override
        public String toString()
        {
            return super.toString();
        }
}
