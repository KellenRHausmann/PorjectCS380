public class driver
{
    public static void main(String[] args)
    {
        coffeeDrink drink1 = new mocha(true, true, true, false);
        coffeeDrink drink2 = new mocha(false, false, false, false);

        System.out.println(drink1 + "" + drink2);
    }
}
