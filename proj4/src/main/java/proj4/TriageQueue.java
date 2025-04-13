// Steven Bruce
// Project 4
// CIS 2353
// Winter 2025
// Prof. John P. Baugh

package proj4;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.LinkedList;

public class TriageQueue<T> extends AbstractQueue<T> {
    // Fields
    private LinkedList<T> elements;

    // Constructor
    public TriageQueue() {
        this.elements = new LinkedList<T>();
    }

    // Overriding required methods for AbstractQueues.
    @Override
    public Iterator<T> iterator() {
        return elements.iterator();
    }

    @Override
    public int size() {
        return elements.size();
    }

    @Override
    public boolean offer(T t) {
        if (t == null) {
            return false;
        }
        elements.add(t);
        return true;
    }

    @Override
    public T poll() {
        Iterator<T> cursor = elements.iterator();
        T t = cursor.next();
        if (t != null) {
            cursor.remove();
            return t;
        }
        return null;
    }

    @Override
    public T peek() {
        return elements.getFirst();
    }
}
