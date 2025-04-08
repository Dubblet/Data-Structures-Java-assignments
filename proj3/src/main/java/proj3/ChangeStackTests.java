// Steven Bruce
// Project 3
// CIS 2353
// Winter 2025
// Prof. John P. Baugh

package proj3;

public class ChangeStackTests {
    public static void main(String[] args) {
        ChangeStack stackTests = new ChangeStack();

        // Test adding to the stack.
        stackTests.push(10);
        stackTests.push(20);
        stackTests.push(30);
        stackTests.push(40);
        stackTests.push(50);
        stackTests.push(60);
        stackTests.printStack();
        System.out.println("Stack size: " + stackTests.getNumElements());

        // Test removing from the stack.
        System.out.println("Popped: " + stackTests.pop());
        stackTests.printStack();
        System.out.println("Stack size: " + stackTests.getNumElements());

        // Test peeking at the top of the stack.
        System.out.println("The top of the stack is: " + stackTests.peekTop());
        System.out.println("Stack size: " + stackTests.getNumElements());

        // Test increasing and decreasing the bottom k items by x amount.
        System.out.println("Testing adding and subtracting:");
        stackTests.increaseValues(3, 5);
        stackTests.printStack();
        stackTests.decreaseValues(4, 1);
        stackTests.printStack();

        // Testing larger k value than size of stack, should just do full stack without error.
        stackTests.increaseValues(10, 3);
        stackTests.printStack();
        stackTests.decreaseValues(10, 7);
        stackTests.printStack();

        // Removing the rest of the stack
        System.out.println("Popped: " + stackTests.pop());
        stackTests.printStack();
        System.out.println("Popped: " + stackTests.pop());
        stackTests.printStack();
        System.out.println("Popped: " + stackTests.pop());
        stackTests.printStack();
        System.out.println("Popped: " + stackTests.pop());
        stackTests.printStack();
        System.out.println("Popped: " + stackTests.pop());
        stackTests.printStack();

        // Testing increase and decrease on empty stack, should do nothing without error.
        stackTests.increaseValues(5, 50);
        stackTests.decreaseValues(5, 10);
        stackTests.printStack();

        // Testing Pop and peek on empty stack. Should throw StackEmptyException.
        // Keeping commented out unless testing for these errors.
//        stackTests.pop();
//        stackTests.peekTop();
    }
}
