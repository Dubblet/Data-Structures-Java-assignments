package proj2;

public class Node {
    // Fields
    private int exponent;
    private int coefficient;
    private Node nextNode;

    // Constructor taking in 2 numbers for an exponent and a coefficient.
    public Node(int exponent, int coefficient) {
        this.exponent = exponent;
        this.coefficient = coefficient;
        this.nextNode = null;
    }

    // Getters and Setters
    public int getExponent() {
        return exponent;
    }

    public void setExponent(int exponent) {
        this.exponent = exponent;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}
