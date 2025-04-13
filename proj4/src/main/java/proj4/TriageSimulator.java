// Steven Bruce
// Project 4
// CIS 2353
// Winter 2025
// Prof. John P. Baugh

package proj4;

import java.util.NoSuchElementException;

public class TriageSimulator {
    // Fields
    private TriageQueue<String> firstPriority;
    private TriageQueue<String> secondPriority;
    private TriageQueue<String> thirdPriority;

    // Constructor
    public TriageSimulator() {
        firstPriority = new TriageQueue<>();
        secondPriority = new TriageQueue<>();
        thirdPriority = new TriageQueue<>();
    }

    /**
     * Adds a patients name to the proper queue based on the priority of their triage code.
     * @param lineFromFile a String including the patient's name and their triage code.
     */
    public void add(String lineFromFile) {
        String code = lineFromFile.substring(lineFromFile.length() - 2).toUpperCase();
        String patientName = lineFromFile.substring(0, lineFromFile.length() - 3);
        // Switch Expression to categorize the patient into the appropriate priorities by their triage code.
        int priorityLevel = switch (code) {
            case "AL", "HA", "ST" -> 1;
            case "BL", "SF", "IW", "KS", "OT" -> 2;
            case "HN" -> 3;
            default -> throw new IllegalStateException("Unexpected value, does not match any priority level: " + code);
        };
        // Switch Statement to add the patient's name to the back of the queue for the priority the fall into.
        switch (priorityLevel) {
            case 1: firstPriority.add(patientName);
                break;
            case 2: secondPriority.add(patientName);
                break;
            case 3: thirdPriority.add(patientName);
                break;
        }
    }

    /**
     * Checks each queue by order of highest priority,
     * and removes the first patient at the front of the highest priority queue that isn't empty.
     * @return the name of the patient that was removed.
     */
    public String remove() {
        if (this.isEmpty()) {
            return "All Queues are empty!";
        } else if (!firstPriority.isEmpty()) {
            return firstPriority.remove();
        } else if (!secondPriority.isEmpty()) {
            return secondPriority.remove();
        } else {
            return thirdPriority.remove();
        }
    }

    /**
     * Checks all 3 queues for if they are empty or not.
     * @return true if all queues are empty, false if there's even a single patient left in any of them.
     */
    public boolean isEmpty() {
        return firstPriority.isEmpty() && secondPriority.isEmpty() && thirdPriority.isEmpty();
    }
}
