// Steven Bruce
// Project 3
// CIS 2353
// Winter 2025
// Prof. John P. Baugh

package proj3;

public class Node {
    // Fields
    private int data;
    private Node next;

    // Constructor
    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    // Getters and Setters
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
