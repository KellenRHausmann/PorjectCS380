public class cappuchino extends coffeeDrink
{
    /**
     * Contructor for making a Cappuchino
     */
    public cappuchino()
    {
        super(6.75, 780);
    }

    /**
     * This is the toString method
     * @return
     */
    @Override
    public String toString()
    {
        return "Price of a Cappuchino is $" + getPrice() + " and it has " + getCalories() + " calories";
    }
}
