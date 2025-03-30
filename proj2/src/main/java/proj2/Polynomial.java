package proj2;

public class Polynomial {
    // Fields
    private Node header;

    // Constructor
    public Polynomial() {
        header = null;
    }

    // Constructor converts string Polynomial to linked list of Monomials.
    public Polynomial(String poly) {
        String[] monomials = poly.split("\\+");
        this.header = convertToNode(monomials[0]);
        Node currentNode = this.header;
        for (int i = 1; i < monomials.length; i++) {
            Node newNode = convertToNode(monomials[i]);
            currentNode.setNextNode(newNode);
            currentNode = currentNode.getNextNode();
        }
    }

    // Copy Constructor
    public Polynomial(Polynomial otherPoly) {
        Node otherPolyNode = otherPoly.getHeader();
        Node newMonomial = new Node(otherPolyNode.getExponent(), otherPolyNode.getCoefficient());
        this.header = newMonomial;
        Node currentNode = newMonomial;

        while (otherPolyNode.getNextNode() != null) {
            otherPolyNode = otherPolyNode.getNextNode();
            Node newNode = new Node(otherPolyNode.getExponent(), otherPolyNode.getCoefficient());
            currentNode.setNextNode(newNode);
            currentNode = newNode;
        }
    }

    // Getters and Setters
    public Node getHeader() {
        return header;
    }

    public void setHeader(Node header) {
        this.header = header;
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

    public void print() {
        Node current = this.header;
        while (current != null) {
            StringBuilder polyString = new StringBuilder();
            polyString.append(current.getCoefficient());
            if (current.getExponent() == 1) {
                polyString.append("x");
            } else if (current.getExponent() > 1) {
                polyString.append("x^");
                polyString.append(current.getExponent());
            }
            if (current.getNextNode() != null) {
                polyString.append("+");
            }
            System.out.println(polyString);
            current = current.getNextNode();
        }
    }

    public static Polynomial add(Polynomial poly1, Polynomial poly2) {
        Polynomial result = new Polynomial(poly1);
        Node resultPointer = result.getHeader();
        Node poly2Pointer = poly2.getHeader();
        // Add together the two polynomials
        while (poly2Pointer != null) {
            if (resultPointer == null) {
                resultPointer = new Node(poly2Pointer.getExponent(), poly2Pointer.getCoefficient());
            }
            if (resultPointer.getExponent() == poly2Pointer.getExponent()) {
                resultPointer.setCoefficient(resultPointer.getCoefficient() + poly2Pointer.getCoefficient());
                resultPointer = resultPointer.getNextNode();
                poly2Pointer = poly2Pointer.getNextNode();
            } else if (resultPointer.getExponent() > poly2Pointer.getExponent()) {
                resultPointer = resultPointer.getNextNode();
            } else if (resultPointer.getExponent() < poly2Pointer.getExponent()) {
                Node newNode = new Node(poly2Pointer.getExponent(), poly2Pointer.getCoefficient());
                newNode.setNextNode(resultPointer.getNextNode());
                resultPointer.setNextNode(newNode);
            }
        }
        // Sort to ensure they are in descending order of exponents
        while (resultPointer != null) {
            Node sorter = resultPointer.getNextNode();
            Node maxExpo = resultPointer;
            while (sorter != null) {
                if (sorter.getExponent() > maxExpo.getExponent()) {
                    maxExpo = sorter;
                }
                sorter = sorter.getNextNode();
            }
            int tempExpo = resultPointer.getExponent();
            int tempCoef = resultPointer.getCoefficient();
            resultPointer.setExponent(maxExpo.getExponent());
            resultPointer.setCoefficient(maxExpo.getCoefficient());
            maxExpo.setExponent(tempExpo);
            maxExpo.setCoefficient(tempCoef);
            resultPointer = resultPointer.getNextNode();
        }

        return result;
    }

}
