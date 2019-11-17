/******************************************************************************
 *  Compilation:  javac RandomizedQueue.java
 *  Execution:    java RandomizedQueue < input.txt
 *  package:
 *  A generic RandomizedQueue, implemented using an array.
 *
 ******************************************************************************/
import java.util.Iterator;
import java.util.NoSuchElementException;
import edu.princeton.cs.algs4.StdRandom;

/**
 * This class implements Iterable<> interface.
 * This class creates a data structure randomized queue which
 * is similar to queue but when dequeue it remove and returns
 * random item.For this StdRandom package is used.
 * In this type we return random item which out delete it using
 * sample() and iterate the items randomly.
 * This is acheived using array data structure.
 * it contains methods of enqueue(), dequeue(), sample()
 * isEmpty(), size() and iterator().
 * this class contains subclass ListIterator class
 * for iterator object.
 * @param <Item> generic type which is to be add in randomized queue.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private Item[] rq; // array for add items.
    private int n; // no of items in array.

    /**
     * Construct an empty randomized queue.
     */
    public RandomizedQueue() {
        rq = (Item[]) new Object[4];
        n = 0;
    }

    /**
     * Check whether randomized queue empty or not.
     * @return boolean type.
     */
    public boolean isEmpty() {
        return n == 0;
    }

    /**
     * this method returns no of items in randomized queue.
     * @return int data type.
     */
    public int size() {
        return n;
    }

    /**
     * this method adds the item to randomized queue.
     * @param item generic data type.
     */
    public void enqueue(final Item item) {
        if (item == null) {
            throw new
            IllegalArgumentException("argument to enqueue() contains null");
        }
        if (n == (rq.length) / 2) resize(2 * rq.length);
        rq[n++] = item;
    }

    /**
     * remove the Item and return a random item.
     * @return generic type.
     */
    public Item dequeue() {
        if (isEmpty()) throw new NoSuchElementException("underflow");
        int x = StdRandom.uniform(n);
        Item item = rq[x];
        rq[x] = rq[n - 1];
        rq[n - 1] = null;
        n--;
        if (n == rq.length / 4) resize(rq.length / 2);
        return item;
    }

    /**
     * private method for resize array when 3/4th filled
     * and 3/4th is empty.
     * @param size required size for resize the array.
     */
    private void resize(final int size) {
       Item[] temp = (Item[]) new Object[size];
       for (int i = 0; i < n; i++) {
           temp[i] = rq[i];
       }
       rq = temp.clone();
    }

    /**
     * return a random item but do not remove it as dequeue.
     * @return Item genetric type.
     */
    public Item sample() {
        if (isEmpty()) throw new NoSuchElementException("underflow");
        int x = StdRandom.uniform(n);
        Item item = rq[x];
        return item;
    }

    /**
     * return an independent iterator over the items
     * in random order.
     */
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    /**
     * main method for testing.
     * @param args string array.
     */
    public static void main(String[] args) {
        RandomizedQueue<String> rqueue = new RandomizedQueue();
        System.out.println(rqueue.isEmpty());
        rqueue.enqueue("prem");
        rqueue.enqueue("vamsi");
        rqueue.enqueue("raviteja");
        rqueue.enqueue("abhiram");
        rqueue.enqueue("chaitanya");
        rqueue.enqueue("dinesh");
        rqueue.enqueue("sandeep");
        rqueue.enqueue("raju");
        rqueue.enqueue("ravi");
        rqueue.enqueue("ravikrishna");
        rqueue.enqueue("akhil");
        for (String str: rqueue) {
            System.out.println(str);
        }
        System.out.println("size of rqueue is" + rqueue.size());
        System.out.println("dequeue item is" + rqueue.dequeue());
        System.out.println("sample item is" + rqueue.sample());
        System.out.println("size of rqueue is" + rqueue.size());
        System.out.println(rqueue.isEmpty());
        for (String str: rqueue) {
             System.out.println(str);
        }
    }

    /**
     * This class implement sIterator<Item> class
     * for creating Iterator object.
     * this class contains methods of hasNext(),
     * next(), and remove().
     */
    private class ListIterator implements Iterator {
        int i;
        public ListIterator() {
            StdRandom.shuffle(rq, 0, n - 1);
            i = 0;
        }

        /**
         * This method checks whether randomized queue contains next
         * item or not.
         * @return boolean type.
         */
        public boolean hasNext() {
            return i < n;
        }

        /**
         * This method calls next item in randomized queue
         * untill it gets null.
         * @return each Item one by one.
         */
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("");
            }
            if (hasNext()) {
                Item item  = (Item) rq[i];
                i++;
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
