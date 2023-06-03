import java.util.*;

public class mocha extends coffeeDrink
{
    private List<additions> additionList;

    /**
     * Contructor for making a mocha
     */
    public mocha(boolean hasMilk, boolean hasSugar, boolean hasSyrup, boolean hasWhippedCream)
    {
        super(5.50, 400);
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
     *
     * @return
     */
    @Override
    public double getPrice()
    {
        double totalPrice = super.getPrice();
        for (additions add : additionList) {
            totalPrice += add.getPrice();
        }
        return totalPrice;
    }

    /**
     * This gets the total calories of a mocha with additions
     * @return Int total calories
     */
    @Override
    public int getCalories()
    {
        int totalCalories = super.getCalories();
        for (additions add : additionList)
        {
            totalCalories += add.getCalories();
        }
        return totalCalories;
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
            return "Mocha with no additions is $" + getPrice() + " and it has " + getCalories() + " calories";
        }
        else
        {
            builder.append("Mocha with additional ");
            for (additions add : additionList)
            {
                builder.append(add.getName());
                builder.append(",");
            }
            builder.append("\n");
            builder.append("Total price: $");
            builder.append(getPrice());
            builder.append("\n");
            builder.append("Total calories: ");
            builder.append(getCalories());
            builder.append("\n");
            return builder.toString();
        }
    }
}
