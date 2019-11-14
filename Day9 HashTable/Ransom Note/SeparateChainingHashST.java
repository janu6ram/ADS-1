public class SeparateChainingHashST<Key, Value> {
    private Node [] st;
    private int n;
    private int m;
    private class Node {
        private Key key;
        private Value value;
        private Node next;
        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    public SeparateChainingHashST(int capacity) {
        n = 0;
        m = capacity;
        st = (Node[]) new Object[m];
    }
    public void put(Key key, Value value) {
        if(value == null) {
            delete(key);
            return;
        }
        if(n == m-2) resize(2*m);
        int i = hash(key);
        Node x;
        for(x = st[i]; x.next != null; x = x.next) {
            if(key.equals(x.key)) {
                x.value = value;
                return;
            }
        }
        Node node = new Node(key, value, null);
        x.next = node;
        n++;
    }
    public int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }
    public void resize(int size) {
        SeparateChainingHashST<Key,Value> temp = new SeparateChainingHashST<Key,Value>(size);
        for(int i = 0; i < m; i++) {
            for(Node x = st[i]; x != null; x = x.next) {
                temp.put(x.key,x.value);
            }
        }
        st = temp.st.clone();
        m = temp.m;
    }
    public Value get(Key key) {
        if(key == null) return null;
        int i = hash(key);
        for(Node x = st[i]; x != null; x = x.next) {
            if(key.equals(x.key)) return x.value;
        }
        return null;
    }
    public boolean contains(Key key) {
        return get(key) != null;
    }
    public void delete(Key key) {
        if(!contains(key)) return;
        int i = hash(key);
        st[i] = delete(st[i], key);
        // if(st[i].next == null && key.equals(st[i].key)) {
        //     st[i] = null;
        //     return;
        // }
        // if(key.equals(st[i].key)) {
        //     st[i] = st[i].next;
        // }
        // for(Node x = st[i]; x != null; x = x.next) {

        // }
    }
    private Node delete(Node x, Key key) {
        if(key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }
}