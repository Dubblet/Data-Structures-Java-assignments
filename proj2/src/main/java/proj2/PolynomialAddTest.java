// Steven Bruce
// CIS-2353
// Winter 2025
// Project 2

package proj2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class PolynomialAddTest {
    public static void main(String[] args) {
        // Create an array of Polynomials and read in text from the file, assigning each line to an object.
        ArrayList<Polynomial> polynomials = new ArrayList<>();
        try {
            File polynomialText = new File("src/main/java/proj2/polynomials.txt");
            Scanner scanner = new Scanner(polynomialText);
            while (scanner.hasNextLine()) {
                Polynomial polynomial = new Polynomial(scanner.nextLine());
                polynomials.add(polynomial);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No File with that name found!");
        }

        printOptions(polynomials);

        Scanner userIn = new Scanner(System.in);
        int selection1 = 0;
        int selection2 = 0;
        // Continue to get user input and add to the Polynomials until they input a value < 0.
        while (true) {
            String inputs = userIn.nextLine();
            String[] numbersText = inputs.split(" ");
            selection1 = Integer.parseInt(numbersText[0]);
            if (selection1 < 0) {
                System.out.println("Have a nice day!");
                break;
            }
            selection2 = Integer.parseInt(numbersText[1]);
            // Check for if user input is out of bounds.
            if (selection1 >= polynomials.size() || selection2 >= polynomials.size()) {
                System.out.println("Input Invalid! One of your entries was out of range. Please enter new indexes.");
            } else {
                // Add the polynomials together, put that new result in the ArrayList, and print the new list again, re-prompting the user.
                Polynomial result = Polynomial.add(polynomials.get(selection1), polynomials.get(selection2));
                polynomials.add(result);
                printOptions(polynomials);
            }
        }
    }

    /**
     * Loops through the ArrayList of Polynomials, printing them out along with their index and a prompt to the user.
     * @param polynomials the ArrayList of Polynomials gotten from the text file initially, then added to by user input.
     */
    public static void printOptions(ArrayList<Polynomial> polynomials) {
        for (Polynomial poly : polynomials) {
            System.out.print(polynomials.indexOf(poly) + ":   ");
            poly.print();
        }
        System.out.println("\nWhich do you wish to add? Enter two indexes with a space between them to add those Polynomials together. Enter -1 to Exit.");
    }
}
