public abstract class coffeeDrink
{
    public double price;
    public int calories;

    /**
     * This is the coffeeDrink contructor
     * @param price
     * @param calories
     */
    public coffeeDrink(double price, int calories)
    {
        this.price = price;
        this.calories = calories;
    }

    /**
     * This gets the price of the drink
     * @return The price of the drink
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * This returns the amount of calaories in a drink
     * @return the amount of calories
     */
    public int getCalories()
    {
        return calories;
    }
}
