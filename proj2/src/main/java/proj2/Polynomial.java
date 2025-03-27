package proj2;

public class Polynomial {
    // Fields
    private Node monomial;

    // Constructor
    public Polynomial() {
        monomial = null;
    }

    // Copy Constructor
    public Polynomial(Polynomial otherPoly) {
        Node otherPolyNode = otherPoly.monomial;
        Node newMonomial = new Node(otherPolyNode.getExponent(), otherPolyNode.getCoefficient());
        this.monomial = newMonomial;
        Node currentNode = newMonomial;

        while (otherPolyNode.getNextNode() != null) {
            otherPolyNode = otherPolyNode.getNextNode();
            Node newNode = new Node(otherPolyNode.getExponent(), otherPolyNode.getCoefficient());
            currentNode.setNextNode(newNode);
            currentNode = newNode;
        }
    }

    // Getters and Setters
    public Node getMonomial() {
        return monomial;
    }

    public void setMonomial(Node monomial) {
        this.monomial = monomial;
    }

}
