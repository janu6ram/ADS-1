/**
 * List of my linkedlists.
 */
class MyLinkedList {
    private Node first;
    private int n;
    /**
     * Constructs an empty list with size initialized to zero.
     */
    public MyLinkedList() {
        first = null;
        n = 0;
    }
    /**
     * Appends the specified element to the end of this list.
     *
     * @param      data  The data
     */
    public void add(String data) {
        Node temp = new Node(data);
        if (n == 0) {
            first = temp;
        } else {
            Node x = first;
            while(x.next != null) {
                x = x.next;
            }
            x.next = temp;
        }
        n++;
    }
    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param      data  The data
     */
    public void addFirst(String data) {
        Node temp = new Node(data);
        if (n == 0) {
            first = temp;
        } else {
            Node oldFirst = first;
            first = temp;
            first.next = oldFirst;
        }
        n++;

    }
    /**
     * Removes all of the elements from this list.
     */
    public void clear() {
        first = null;
        n = 0;
    }
    /**
     * Returns true if this list contains the specified element.
     *
     * @param      data  The data
     *
     * @return     { description_of_the_return_value }
     */
    public boolean contains(String data) {
        for(Node x = first; x != null; x = x.next) {
            if(x.data == data) {
                return true;
            }
        }
        return false;
     }
    /**
     * Returns the element at the specified position in this list.
     *
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    public String get(int index){
        int i = 0;
        for(Node x = first; i < n; x = x.next) {
            if(index == i) {
                return x.data;
            }
            i++;
        }
        return null;
     }
    /**
     * Returns the first element in this list.
     *
     * @return     The first.
     */
    public String getFirst() {
        if(first == null) return null;
        return first.data;
     }
    /**
     * Returns the last element in this list.
     *
     * @return     The last.
     */
    public String getLast() {
        if(first == null) return null;
        int i = 0;
        Node x = first;
        for(x = first; i < n - 1; x = x.next) {
            i++;
        }
        return x.data;
     }
    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return     { description_of_the_return_value }
     */
    public String remove() {
        if(n == 0) return null;
        String data = first.data;
        first = first.next;
        n--;
        return data;
     }
    /**
     * Removes and returns the last element from this list.
     *
     * @return     { description_of_the_return_value }
     */
    public String removeLast() {
        if(first == null) return null;
        String data;
        if(n == 1) {
           data =  first.data;
           first = null;
           n--;
           return data;
        }
        int i = 0;
        Node x = first;
        for(x = first; i < n - 2; x = x.next) {
            i++;
        }
        data = x.next.data;
        x.next = null;
        n--;
        return data;
    }
    /**
     * Returns the number of elements in this list.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return n;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        if(n == 0) {
            str = "LinkedList is empty";
        }
        for(Node x = first; x != null; x = x.next) {
            str += "[" + x.data + "]";
        }
        return str;
     }
}
