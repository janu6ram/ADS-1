import java.util.*;
import java.util.Iterator;
public class Stack<Item> implements Iterable<Item> {
     private Node<Item> first;
     private int n;
    private static class Node<Item> {
         private Item item;
         private Node<Item> next;
    }
    public Stack() {
        first = null;
        n = 0;
    }
    public void push(Item item) {
        Node<Item> oldfirst = first;
        first = new Node<Item>();
        first.item = item;
        first.next = oldfirst;
        n++;
    }
    public Item pop() {
        if (isEmpty()) return null;
        Item item = first.item;        // save item to return
        first = first.next;            // delete first node
        n--;
        return item;                   // return the saved item
    }
    public boolean isEmpty() {
        if (first == null) return true;
        return false;
    }
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }
    private class ListIterator implements Iterator<Item> {
        Node<Item> current = first;

        public boolean hasNext() {
            return current != null;
        }
        public Item next() {
            if(hasNext()) {
                Item item = current.item;
                current = current.next;
                return item;
            }
            return null;
        }
        public void remove() {
            try{
                throw new Exception();
            }
            catch(Exception Ex) {
                System.out.println("Not supported Function");
            }
        }
    }
}