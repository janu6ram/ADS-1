/******************************************************************************
 *  Compilation:  javac Permutation.java
 *  Execution:    java Permutation < input.txt
 *
 *  A generic Deque, implemented using a doubly linked list.
 *
 ******************************************************************************/
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * takes an integer k as a command-line argument;
 * reads a sequence of strings from standard input using StdIn.readString();
 * and prints exactly k of them, uniformly at random.
 * Print each item from the sequence at most once.
 * The running time of Permutation must be linear in the
 * size of the input. You may use only a constant amount
 * of memory plus either RandomizedQueue object of maximum size at most n.
 */
public class Permutation {

    /**
     * main method.
     * using stdin package read the data in text document.
     * and stored in randomized queue.
     * @param args contains k i.e no of outputs.
     */
    public static void main(String[] args) {
        RandomizedQueue<String> rq = new RandomizedQueue();
        while (!StdIn.isEmpty()) {
            String str = StdIn.readString();
            rq.enqueue(str);
        }
        int count  = Integer.parseInt(args[0]);
        for (int i = 0; i < count; i++) {
            StdOut.println(rq.sample());
        }
    }
}
