import java.util.ArrayList;
import java.util.List;

public class Pizza implements Comparable<Pizza> {
    // Constants
    public enum CrustType {
        PLAIN,
        BUTTER,
        GARLIC,
        GARLICBUTTER,
        CHEESE
    }
    public enum SizeType {
        SMALL,
        MEDIUM,
        LARGE,
        XLARGE,
        XXLARGE,
        PARTY
    }
    List<String> AvailableToppings = List.of("cheese", "onion", "green pepper", "ham",
            "pineapple", "pepperoni", "ground beef", "italian sausage", "anchovies");

    // Fields
    private CrustType crust;
    private ArrayList<String> toppings;
    private SizeType size;

    // Constructor with no params, sets everything to a default pizza
    public Pizza() {
        crust = CrustType.PLAIN;
        toppings = new ArrayList<String>();
        size = SizeType.SMALL;
    }

    // Constructor with params, client choosing each field
    public Pizza(CrustType crust, ArrayList<String> toppings, SizeType size) {
        this.crust = crust;
        this.toppings = toppings;
        this.size = size;
    }

    // Getters and Setters for the private Fields
    public CrustType getCrust() {
        return crust;
    }

    public void setCrust(CrustType crust) {
        this.crust = crust;
    }

    public ArrayList<String> getToppings() {
        return toppings;
    }

    public void setToppings(ArrayList<String> toppings) {
        this.toppings = toppings;
    }

    public SizeType getSize() {
        return size;
    }

    public void setSize(SizeType size) {
        this.size = size;
    }

    /**
     * Checks if they input an acceptable topping and if not skip that topping and print out a notification.
     * @param topping a string of a topping the client wants on their pizza.
     */
    public void addTopping(String topping) {
        if (AvailableToppings.contains(topping)) {
            toppings.add(topping);
        } else {
            System.out.println("Sorry, we do not offer " + topping + " as a topping option for our pizzas.");
        }
    }

    /**
     * Overriding toString method for the Pizza class, so it will print out the crust and toppings.
     * @return a String of the crust and toppings for the pizza.
     */
    @Override
    public String toString() {
        StringBuilder pizzaString = new StringBuilder();
        pizzaString.append("This pizza has a " + crust + " crust and the following toppings:");
        // Print 'none' for the toppings if none have been added, otherwise loop through the list of toppings adding each one.
        if (toppings.isEmpty()) {
            pizzaString.append("\nnone");
        } else {
            for (String topping : toppings) {
                pizzaString.append("\n" + topping);
            }
        }
        return pizzaString.toString();
    }

    /**
     * Checks if two pizzas have the same crust and number of toppings.
     * @param pizza another pizza to compare toppings and crust against this one.
     * @return a boolean, true if they have the same crust and number of toppings, false if not.
     */
    public boolean equals(Pizza pizza) {
        int pizzaToppingNum = this.toppings.size();
        int otherPizzaToppingNum = pizza.toppings.size();
        return this.crust == pizza.crust && pizzaToppingNum == otherPizzaToppingNum;
    }

    /**
     * Compares two pizzas, based on their number of toppings and crust and decides which one is better.
     * @param otherPizza Pizza object B to be compared to against this pizza A.
     * @return an int. 1 if this pizza is better than otherPizza, -1 if otherPizza is better, and 0 if they are equal.
     */
    @Override
    public int compareTo(Pizza otherPizza) {
        int pizzaToppingNum = this.toppings.size();
        int otherPizzaToppingNum = otherPizza.toppings.size();

        // Uses equals method to see if they are the same.
        if (this.equals(otherPizza)) {
            return 0;
        } else {
            // If not, checks which one has more toppings than the other.
            if (pizzaToppingNum < otherPizzaToppingNum) {
                return -1;
            } else if (pizzaToppingNum > otherPizzaToppingNum) {
                return 1;
            } else {
                // If they have the same number of toppings, uses the compareTo method to compare the crusts.
                // For Enums, the compareTo method checks the order of the constants to get the 'rankings'.
                return this.crust.compareTo(otherPizza.crust);
            }
        }
    }
}