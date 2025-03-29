package proj2;

public class Polynomial {
    // Fields
    private Node monomial;

    // Constructor
    public Polynomial() {
        monomial = null;
    }

    // Constructor converts string Polynomial to linked list of Monomials.
    public Polynomial(String poly) {
        String[] monomials = poly.split("[+\\-*/]");
        this.monomial = convertToNode(monomials[0]);
        Node currentNode = this.monomial;
        for (int i = 1; i < monomials.length; i++) {
            Node newNode = convertToNode(monomials[i]);
            currentNode.setNextNode(newNode);
            currentNode = currentNode.getNextNode();
        }
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

    public Node convertToNode(String mono) {
        int expo;
        if (!mono.contains("x")) {
            expo = 0;
        } else if (mono.contains("^")) {
            expo = Integer.parseInt(mono.substring(mono.indexOf("^") + 1));
        } else {
            expo = 1;
        }
        int coef = Integer.parseInt(mono.substring(0, mono.indexOf("x") - 1));

        return new Node(expo, coef);
    }
    
}
