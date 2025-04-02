// Steven Bruce
// Project 3
// CIS 2353
// Winter 2025
// Prof. John P. Baugh

package proj3;

public class ChangeStack {
    // Fields
    private int numElements;
    private Node top;

    // Constructor
    public ChangeStack() {
        this.numElements = 0;
        this.top = null;
    }

    // Getters and Setters
    public int getNumElements() {
        return numElements;
    }

    public void setNumElements(int numElements) {
        this.numElements = numElements;
    }

    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }


}
