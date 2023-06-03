public class latte extends coffeeDrink
{
        /**
         * Contructor for making a latte
         */
        public latte()
        {
            super(4.25, 250);
        }

        /**
         * This is the toString method
         * @return
         */
        @Override
        public String toString()
        {
            return "Price of a Latte is $" + getPrice() + " and it has " + getCalories() + " calories";
        }
}
