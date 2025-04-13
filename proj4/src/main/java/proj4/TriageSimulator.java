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

    public void add(String lineFromFile) {
        String code = lineFromFile.substring(lineFromFile.length() - 2).toUpperCase();
        String patientName = lineFromFile.substring(0, lineFromFile.length() - 3);
        int priorityLevel = switch (code) {
            case "AL", "HA", "ST" -> 1;
            case "BL", "SF", "IW", "KS", "OT" -> 2;
            case "HN" -> 3;
            default -> throw new IllegalStateException("Unexpected value, does not match any priority level: " + code);
        };
        switch (priorityLevel) {
            case 1: firstPriority.add(patientName);
                break;
            case 2: secondPriority.add(patientName);
                break;
            case 3: thirdPriority.add(patientName);
                break;
        }
    }

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

    public boolean isEmpty() {
        return firstPriority.isEmpty() && secondPriority.isEmpty() && thirdPriority.isEmpty();
    }
}
