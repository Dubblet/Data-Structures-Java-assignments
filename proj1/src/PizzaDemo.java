import java.util.ArrayList;
import java.util.Arrays;

public class PizzaDemo {
    public static void main(String[] args) {

        // Create a pizza with basic Constructor, add toppings, and print it out.
        Pizza testPizza1 = new Pizza();
        testPizza1.addTopping("pineapple");
        testPizza1.addTopping("ham");
        // Bacon isn't on the list of toppings, so should print out a warning and leave it off the pizza.
        testPizza1.addTopping("bacon");
        System.out.println(testPizza1);

        // Create a list of toppings and then a new pizza with those toppings using the Constructor with params.
        // Do this multiple times to have different pizzas to compare to each other.
        ArrayList<String> testPizza2Toppings = new ArrayList<>(Arrays.asList("cheese", "pepperoni"));
        Pizza testPizza2 = new Pizza(Pizza.CrustType.CHEESE, testPizza2Toppings, Pizza.SizeType.XLARGE);
        System.out.println(testPizza2);

        ArrayList<String> testPizza3Toppings = new ArrayList<>(Arrays.asList("cheese", "anchovies"));
        Pizza testPizza3 = new Pizza(Pizza.CrustType.CHEESE, testPizza3Toppings, Pizza.SizeType.MEDIUM);
        System.out.println(testPizza3);

        ArrayList<String> testPizza4Toppings = new ArrayList<>(Arrays.asList("cheese", "onion", "green pepper", "ground beef", "italian sausage"));
        Pizza testPizza4 = new Pizza(Pizza.CrustType.GARLIC, testPizza4Toppings, Pizza.SizeType.PARTY);
        System.out.println(testPizza4);

        // They have the same number of toppings since bacon isn't actually added to pizza 1, pizza 2 has the better crust, so the result will be negative.
        System.out.println("Comparing pizza 1 and 2: " + testPizza1.compareTo(testPizza2));
        System.out.println(testPizza1.equals(testPizza2));

        // These pizzas have the same number of toppings and same crust. The only difference is size, but size is not used in our comparisons,
        // so the result will be 0 since they are equal. The .equals method will also return true.
        System.out.println("Comparing pizza 2 and 3: " + testPizza2.compareTo(testPizza3));
        System.out.println(testPizza2.equals(testPizza3));

        // Pizza 4 has more toppings than pizza 3, so the result will be positive.
        System.out.println("Comparing pizza 4 and 3: " + testPizza4.compareTo(testPizza3));
        System.out.println(testPizza4.equals(testPizza3));

    }
}
