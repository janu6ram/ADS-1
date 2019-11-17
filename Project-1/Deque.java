/******************************************************************************
 *  Compilation:  javac Deque.java
 *  Execution:    java Deque < input.txt
 *
 *  A generic Deque, implemented using a doubly linked list.
 *
 ******************************************************************************/
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * This class implements Iterable<> interface.
 * This class creates a data structure deque which
 * is double ended queue.
 * In this type we can add and remove items from both
 * ends.
 * it contains methods of addFirst(),addLast(),
 * removeFirst(), removeLast(),isEmpty(), size()
 * and iterator().
 * this class contains two sub classes. one is Node
 * for creating double linkedlist type data structure.
 * Another one is ListIterator class for iterator object.
 * @param <Item> generic type which is to be add in deque.
 */
public class Deque<Item> implements Iterable<Item> {
    private Node first; // begining of the deque.
    private Node last; //  end of deque.
    private int n; // no of items in deque.

    /**
     * This class contains feilds prev, next and item.
     * helper linked list class.
     */
    private class Node {
        private Node prev;
        private final Item item;
        private Node next;
        public Node(Item item) {
            this.item = item;
            prev = null;
            next = null;
        }
    }

    /**
     * constructor for empty deque.
     * initilizing first and last node with "null".
     * no of items in deque n with "0".
     */
    public Deque() {
        first = null;
        last = null;
        n = 0;

    }

    /**
     * if deque has no elements this method returns false.
     * else returns true.
     * @return boolean type.
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * This method returns the no of items in deque.
     * @return Integer type.
     */
    public int size() {
        return n;
    }

    /**
     * This method adds Items in the beginning of the deque.
     * for this, If first node is null then insert the element
     * in the first.
     * else add the new item in first.prev using dounle linked list
     * data structure.
     * its time complixity is constant.
     * @param item generic type which is to be add to deque.
     */
    public void addFirst(final Item item) {
        if (item == null) {
            throw new
            IllegalArgumentException("argument to addFirst() contains null");
        }
        Node temp = new Node(item);
        if (first == null) {
            first = temp;
            last = first;
        } else {
            first.prev = temp;
            temp.next = first;
            first = temp;
        }
        n++;
    }

    /**
     * This method adds Items in the last of the deque.
     * for this, If first node is null then insert the element
     * in the first.
     * else add the new item in last.next using dounle linked list
     * data structure.
     * its time complixity is constant.
     * @param item generic type which is to be add to deque.
     */
    public void addLast(final Item item) {
        if (item == null) throw new
                IllegalArgumentException("argument to addLast() contains null");
        Node temp = new Node(item);
        if (first == null) {
            first = temp;
            last = first;
        } else {
            temp.prev = last;
            last.next = temp;
            last = temp;
        }
        n++;
    }

    /**
     * this method is for remove an item from beginning of
     * the deque.
     * its time complixity is constant.
     * @return generic type which is to be add to deque.
     */
    public Item removeFirst() {
        if (isEmpty()) throw new NoSuchElementException("deque underflow");
        Item item = first.item;
        first = first.next;
        if (first == null) {
            last = null;
        } else {
            first.prev = null;
        }
        n--;
        return item;
    }

    /**
     * this method is for remove an item from last of
     * the deque.
     * its time complixity is constant.
     * @return generic type which is to be add to deque.
     */
    public Item removeLast() {
        if (isEmpty()) throw new NoSuchElementException("deque underflow");
        Item item = last.item;
        last = last.prev;
        if(last == null) {
            first = null;
        } else {
            last.next = null;
        }
        n--;
        return item;
    }

    /**
     * This method inherits from Iterable interface.
     * this method returns iterator object over items
     * in order from front to back.
     * @return Iterator object type.
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    /**
     * main method for testing.
     * @param args String array.
     */
    public static void main(final String[] args) {
        Deque<String> deque = new Deque<String>();
        System.out.println(deque.isEmpty());
        deque.addLast("van");
        System.out.println(deque.isEmpty());
        deque.addFirst("apple");
        deque.addFirst("boy");
        deque.addLast("zoo");
        deque.removeFirst();
        deque.removeLast();
        deque.removeLast();
        deque.removeLast();
        System.out.println(deque.isEmpty());
        for (String str :deque) {
            System.out.println(str);
        }
    }

    /**
     * This class implement sIterator<Item> class
     * for creating Iterator object.
     * this class contains methods of hasNext(),
     * next(), and remove().
     */
    private class ListIterator implements Iterator<Item> {
        private Node current = first; // for access each node.

        /**
         * This method checks whether deque contains next
         * item or not.
         * @return boolean type.
         */
        public boolean hasNext() {
            return current != null;
        }

        /**
         * This method calls next item in deque
         * untill it gets null.
         * @return each Item one by one.
         */
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("");
            }
            if (hasNext()) {
                Item item = current.item;
                current = current.next;
                return item;
            }
            return null;
        }

        /**
         * this does not support operation.
         */
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
