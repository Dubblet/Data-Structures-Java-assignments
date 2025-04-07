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

    public void push(int item) {
        Node newNode = new Node(item);
        newNode.setNext(top);
        top = newNode;
        numElements++;
    }

    public int pop() {
        try {
            int data = top.getData();
            top = top.getNext();
            numElements--;
            return data;
        } catch (NullPointerException e) {
            throw new StackEmptyException("Stack is empty!", e);
        }
    }

    public int peekTop() {
        try {
            return top.getData();
        } catch (NullPointerException e) {
            throw new StackEmptyException("Stack is empty!", e);
        }
    }

    public void increaseValues(int k, int amount) {
        Node cursor = getStackFromBottom(k);
        while (cursor != null) {
            cursor.setData(cursor.getData() + amount);
            cursor = cursor.getNext();
        }
    }

    public void decreaseValues(int k, int amount) {
        Node cursor = getStackFromBottom(k);
        while (cursor != null) {
            cursor.setData(cursor.getData() - amount);
            cursor = cursor.getNext();
        }
    }

    private Node getStackFromBottom(int k) {
        if (top == null) {
            return null;
        }
        Node cursor = top;
        int stackSize = numElements;
        while (stackSize > k) {
            cursor = cursor.getNext();
            stackSize--;
        }
        return cursor;
    }

    private static class StackEmptyException extends RuntimeException {
        public StackEmptyException(String errorMessage, Throwable error) {
            super(errorMessage, error);
        }
    }
}
