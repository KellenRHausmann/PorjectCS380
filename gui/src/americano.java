public class americano extends coffeeDrink
{
    /**
     * Contructor for making a americano
     */
    public americano()
    {
        super(2.00, 100);
    }

    /**
     * This is the toString method
     * @return
     */
    @Override
    public String toString()
    {
        return "Price of a Americano is $" + getPrice() + " and it has " + getCalories() + " calories";
    }
}
