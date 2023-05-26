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
            return "Latte";

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
