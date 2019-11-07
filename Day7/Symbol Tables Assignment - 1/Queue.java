import java.util.Iterator;
public class Queue<Item> implements Iterable<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int size;
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }
    public Queue() {
        first = null;
        last = null;
        size = 0;
    }
    public int size() {
        return size;
    }
    public void Enqueue(Item item) {
        Node<Item> oldlast = last;
        last = new Node<Item>();
        last.item = item;
        last.next = null;
        if(isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }
        size++;
    }
    public Item Dequeue() {
        if (isEmpty()) return null;
        Item item = first.item;
        first = first.next;
        size--;
        if (isEmpty()) last = null;
        return item;
    }
    public boolean isEmpty() {
        return first == null;
    }
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }
    public Iterator<Item> iterator() {
        return new ListIterator();
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
