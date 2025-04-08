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

    /**
     * Adds new node to the top of the stack.
     * @param item integer to the stored in the stack.
     */
    public void push(int item) {
        Node newNode = new Node(item);
        newNode.setNext(top);
        top = newNode;
        numElements++;
    }

    /**
     * Removes the node on the top of the stack, making the next node in the list the new top.
     * @return the integer stored in the node that is being removed.
     */
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

    /**
     * Looks at the top node without removing it.
     * @return the integer stored in the top node.
     */
    public int peekTop() {
        try {
            return top.getData();
        } catch (NullPointerException e) {
            throw new StackEmptyException("Stack is empty!", e);
        }
    }

    /**
     * Adds to the bottom k number of nodes by x amount.
     * @param k number of nodes to add to, from the bottom.
     * @param amount amount to increase the stored integers by.
     */
    public void increaseValues(int k, int amount) {
        Node cursor = getStackFromBottom(k);
        while (cursor != null) {
            cursor.setData(cursor.getData() + amount);
            cursor = cursor.getNext();
        }
    }

    /**
     * Subtracts from the bottom k number of nodes by x amount.
     * @param k number of nodes to subtract from, from the bottom.
     * @param amount amount to decrease the stored integers by.
     */
    public void decreaseValues(int k, int amount) {
        Node cursor = getStackFromBottom(k);
        while (cursor != null) {
            cursor.setData(cursor.getData() - amount);
            cursor = cursor.getNext();
        }
    }

    /**
     * Finds the bottom k nodes by utilizing the number of elements that is incremented as nodes are pushed and popped.
     * @param k number of nodes from the bottom that are needed.
     * @return The node that is 'k' nodes away from the last/bottom node in the stack.
     */
    private Node getStackFromBottom(int k) {
        if (top == null) {
            return null;
        }
        Node cursor = top;
        int stackSize = numElements;
        // Skips Nodes until k and the remaining number of nodes are equal.
        while (stackSize > k) {
            cursor = cursor.getNext();
            stackSize--;
        }
        return cursor;
    }

    /**
     * Loops through the stack and prints out the data values of each node from top to bottom.
     */
    public void printStack() {
        if (top == null) {
            System.out.println("Stack is empty!");
            return;
        }
        Node pointer = top;
        while (pointer != null) {
            System.out.print(pointer.getData() + " ");
            pointer = pointer.getNext();
        }
        System.out.println();
    }

    /**
     * Custom Exception, to be used if attempting to remove from or look at elements in an empty stack.
     */
    private static class StackEmptyException extends RuntimeException {
        public StackEmptyException(String errorMessage, Throwable error) {
            super(errorMessage, error);
        }
    }
}
