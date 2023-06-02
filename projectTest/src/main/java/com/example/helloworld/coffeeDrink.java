package com.example.helloworld;
import java.util.*;
public abstract class coffeeDrink
{
    public double price;
    public int calories;
    private List<additions> additionList;

    /**
     * This is the coffeeDrink contructor
     * @param price
     * @param calories
     */
    public coffeeDrink(double price, int calories, boolean hasMilk, boolean hasSugar, boolean hasSyrup, boolean hasWhippedCream)
    {
        this.price = price;
        this.calories = calories;
        additionList = new ArrayList<>();

        if(hasMilk)
        {
            additionList.add(additions.milk);
        }
        if(hasSugar)
        {
            additionList.add(additions.sugar);
        }
        if(hasSyrup)
        {
            additionList.add(additions.syrup);
        }
        if(hasWhippedCream)
        {
            additionList.add(additions.whipCream);
        }
    }

    /**
     * This gets the price of the drink
     * @return The price of the drink
     */
    public double getPrice()
    {
        double totalPrice = 0.0;
        for (additions add : additionList)
        {
            totalPrice += add.getPrice();
        }
        return totalPrice;
    }

    public int getCalories()
    {
        int totalCalories = 0;
        for (additions add : additionList)
        {
            totalCalories += add.getCalories();
        }
        return totalCalories;
    }

    public abstract String getType();

    public List<additions> getAdditionList()
    {
        return additionList;
    }
    /**
     * This is the toString method
     * @return
     */
    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();
        if(additionList.isEmpty())
        {
            builder.append(getType() + " with no additions \n");
            builder.append("\n");
            builder.append("\t Total price: $"+ getPrice() + "\n");
            builder.append("\t Total calories: " + getCalories() + "\n");
            return builder.toString();
        }
        else
        {
            builder.append(getType() + " with additional ");
            for (additions add : additionList)
            {
                builder.append(add.getName());
                builder.append(",");
            }
            builder.append("\n");
            builder.append("\t Total price: $"+ getPrice() + "\n");
            builder.append("\t Total calories: " + getCalories() + "\n");
            return builder.toString();
        }
    }
}

