// Steven Bruce
// Project 4
// CIS 2353
// Winter 2025
// Prof. John P. Baugh

package proj4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TriageSimulationTest {
    public static void main(String[] args) {
        // Create a TriageSimulator and read in a file.
        TriageSimulator triageTests = new TriageSimulator();
        try {
            File patientList = new File("src/main/java/proj4/PatientList.txt");
            Scanner scanner = new Scanner(patientList);
            System.out.println("Printing rows from file:");
            // Loop through the file printing out each line and adding them to the queues in triageTests.
            while (scanner.hasNextLine()) {
                String patientLine = scanner.nextLine();
                triageTests.add(patientLine);
                System.out.println(patientLine);
            }
        } catch (FileNotFoundException e) {
            System.out.println("No File with that name found!");
        }
        System.out.println("\nRemoving from Queues by priority:");
        // Loops through, removing patients until all queues are empty.
        while (!triageTests.isEmpty()) {
            System.out.println(triageTests.remove());
        }
        // Finally, one extra call to .remove, to show all queues are empty.
        System.out.println("\n" + triageTests.remove());
    }
}
