import java.util.Iterator;

public class SequentialSearchST<Key,Value> {
    private Node first;
    private int n;
    private class Node {
        private Key key;
        private Value value;
        private Node next;
        private Node(Key key, Value value) {
            this.key = key;
            this.value = value;
            next = null;
        }
    }
    public void put(Key key, Value value) {
        if(n == 0) {
            first = new Node(key, value);
            n++;
            return;
        } else {
            for(Node z = first; z.next != null; z = z.next) {
                if(z.key.equals(key)) {
                    z.value = value;
                    return;
                }
            }
        }
        Node oldfirst = first;
        first = new Node(key, value);
        first.next = oldfirst;
        n++;
    }
    public Value get(Key key) {
        Node temp = null;
        Node temp2 = null;
        Node x;
        for(x = first; x.next != null; x = x.next) {
            if(key.equals(x.key)) {
                temp = x;
            }
        }
        temp2 = new Node(temp.key, temp.value);
        delete(temp);
        x.next = temp2;
        n++;
        return temp.value;
    }
    public void delete(Node node) {
        Node y;
        for(y = first; y.next != null; y = y.next) {
            if(y.next.equals(node)){
                y.next = node.next;
                n--;
                return;
            }
        }
    }
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue();
        Node x;
        for(x = first; x.next != null; x = x.next) {
            queue.Enqueue(x.key);
        }
        queue.Enqueue(x.key);
        return queue;
    }



}