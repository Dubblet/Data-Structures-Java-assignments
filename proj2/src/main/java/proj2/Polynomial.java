package proj2;

public class Polynomial {
    // Fields
    private Node header;

    // Constructor
    public Polynomial() {
        header = null;
    }

    /**
     * Constructor converts string Polynomial to linked list of monomials.
     * Uses convertToNode method to convert first monomial string to a node, sets the header equal to it,
     * then loops through the rest, making them nodes and linking them together.
     * @param poly a string representing a polynomial
     */
    public Polynomial(String poly) {
        // Splits polynomial on the '+' symbol, so each monomial is its own string in an array of strings.
        String[] monomials = poly.split("\\+");
        this.header = convertToNode(monomials[0]);
        Node currentNode = this.header;
        for (int i = 1; i < monomials.length; i++) {
            Node newNode = convertToNode(monomials[i]);
            currentNode.setNextNode(newNode);
            currentNode = currentNode.getNextNode();
        }
    }

    /**
     * Copy Constructor, takes a Polynomial and makes a new Polynomial copy of it.
     * Loops through the original, creating and linking new nodes while copying the data from each original one.
     * @param otherPoly the polynomial object to be copied
     */
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

    /**
     * Helper method to convert a string into a node.
     * Checks the string for x and ^ and assigns the exponent and finds the coefficient accordingly.
     * @param mono a String, of a monomial.
     * @return a Node object holding the int values for the exponent and coefficient.
     */
    public Node convertToNode(String mono) {
        int expo;
        int coef;
        if (!mono.contains("x")) {
            expo = 0;
            coef = Integer.parseInt(mono);
        } else if (mono.contains("^")) {
            expo = Integer.parseInt(mono.substring(mono.indexOf("^") + 1));
            coef = Integer.parseInt(mono.substring(0, mono.indexOf("x")));
        } else {
            expo = 1;
            coef = Integer.parseInt(mono.substring(0, mono.indexOf("x")));
        }
        return new Node(expo, coef);
    }

    /**
     * Prints out the polynomial as a string when called by a Polynomial object. Loops through each node in the
     * polynomial and uses a String Builder to re-insert the 'x' and '^' in the appropriate locations.
     */
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
            System.out.print(polyString);
            current = current.getNextNode();
        }
        // Adds a new line at the end.
        System.out.println();
    }

    /**
     * Adds two polynomial objects together, returning the result as a new Polynomial without losing the originals.
     * Loops through both and appropriately adds together coefficients where exponents match.
     * @param poly1
     * @param poly2
     * @return A new polynomial with the results of the addition.
     */
    public static Polynomial add(Polynomial poly1, Polynomial poly2) {
        // Make a copy using copy Constructor of poly1 for the result to be stored in.
        Polynomial result = new Polynomial(poly1);
        Node resultPointer = result.getHeader();
        Node poly2Pointer = poly2.getHeader();
        // Add together the two polynomials result and poly2, storing in result.
        while (poly2Pointer != null) {
            // If there's no monomials left in result, add what's left off poly2 as nodes on the end.
            if (resultPointer == null) {
                resultPointer = new Node(poly2Pointer.getExponent(), poly2Pointer.getCoefficient());
            }
            // If exponents are equal, add together and increment both.
            if (resultPointer.getExponent() == poly2Pointer.getExponent()) {
                resultPointer.setCoefficient(resultPointer.getCoefficient() + poly2Pointer.getCoefficient());
                resultPointer = resultPointer.getNextNode();
                poly2Pointer = poly2Pointer.getNextNode();
            // If result has larger exponent, just leave as is and increment result, but not poly2.
            } else if (resultPointer.getExponent() > poly2Pointer.getExponent()) {
                resultPointer = resultPointer.getNextNode();
            // If poly2 has a larger exponent, create a new node in result and add the values from poly2 to it,
            // then increment poly2, but not result.
            } else if (resultPointer.getExponent() < poly2Pointer.getExponent()) {
                Node newNode = new Node(poly2Pointer.getExponent(), poly2Pointer.getCoefficient());
                newNode.setNextNode(resultPointer.getNextNode());
                resultPointer.setNextNode(newNode);
                poly2Pointer = poly2Pointer.getNextNode();
            }
        }
        polySort(result.getHeader());
        return result;
    }

    /**
     * Sorts a polynomial object by exponents, from largest to smallest using selection sort to swap 2 nodes at a time.
     * Assigns the current node values to temporary ints. Loops through, making the current node values equal the
     * largest values found, and making the node that held the largest exponent equal to the values from the temp ints.
     * @param sorter the header node of a polynomial.
     */
    public static void polySort(Node sorter) {
        while (sorter != null) {
            Node index = sorter.getNextNode();
            Node maxExpo = sorter;
            while (index != null) {
                if (index.getExponent() > maxExpo.getExponent()) {
                    maxExpo = index;
                }
                index = index.getNextNode();
            }
            int tempExpo = sorter.getExponent();
            int tempCoef = sorter.getCoefficient();
            sorter.setExponent(maxExpo.getExponent());
            sorter.setCoefficient(maxExpo.getCoefficient());
            maxExpo.setExponent(tempExpo);
            maxExpo.setCoefficient(tempCoef);
            sorter = sorter.getNextNode();
        }
    }
}
