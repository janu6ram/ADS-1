public class Queue<Item> {
    private Node<Item> first;
    private Node<Item> last;
    private int size;
    private static class Node<Item> {
        private Item item;
        private Node<Item> next;
    }
    public void Enqueue(Item item) {
        Node oldlast = last;
        Node last = new Node();
        last.item = item;
        if(isEmpty()) {
            first = last;
        } else {
            oldlast.next = last;
        }

    }
    public Item Dequeue() {
        Item item = first.item;
        first = first.next;
        return item;
    }
    public boolean isEmpty() {
        return first == null;
    }
}
