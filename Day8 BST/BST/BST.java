public class BST<Key extends Comparable<Key>, Value> {
    private Node root;
    private class Node {
        private Key key;
        private Value value;
        private Node leftLink;
        private Node rightLink;
        private int size;
        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }
    public void put(Key key, Value value) {
        if(key == null) return;
        if(value == null) {
            delete(key);
            return;
        }
        root = put(root,key, value);
    }
    private Node put(Node x, Key key,Value value) {
        if(x == null) return new Node(key,value,1);
        int comp = key.compareTo(x.key);
        if(comp < 0) {
            x.leftLink = put(x.leftLink, key, value);
        } else if(comp > 0) {
            x.rightLink = put(x.rightLink, key, value);
        } else {
            x.value = value;
        }
        x.size = 1 + size(x.leftLink) + size(x.rightLink);
        return x;
    }
    public int size() {
        return size(root);
    }
    public int size(Node x) {
        if(x == null) return 0;
        return x.size;
    }
    private boolean isEmpty() {
        return size() == 0;
    }
    public Value get(Key key){
        return get(root,key);
    }
    private Value get(Node x, Key key) {
        if(x == null) return null;
        int comp = key.compareTo(x.key);
        if(comp < 0) {
            return get(x.leftLink, key);
        } else if(comp > 0) {
            return get(x.rightLink, key);
        } else {
            return x.value;
        }
    }
    public void deleteMax() {
        if(isEmpty()) return;
        root = deleteMax(root);
    }
    private Node deleteMax(Node x) {
        if(x.rightLink == null) return x.leftLink;
        x.rightLink = deleteMax(x.rightLink);
        x.size = 1 + size(x.leftLink) + size(x.rightLink);
        return x;
    }
    public void deleteMin() {
        if(isEmpty()) return;
        root = deleteMin(root);
    }
    private Node deleteMin(Node x) {
        if(x.leftLink == null) return x.rightLink;
        x.leftLink = deleteMin(x.leftLink);
        x.size = 1 + size(x.leftLink) + size(x.rightLink);
        return x;
    }
    public void delete(Key key) {
        if(key == null) return;
        root = delete(root, key);
    }
    private Node delete(Node x, Key key) {
        if(x == null) return null;
        int comp = key.compareTo(x.key);
        if(comp < 0) x.leftLink = delete(x.leftLink, key);
        else if(comp > 0) x.rightLink = delete(x.rightLink, key);
        else {
            if(x.leftLink == null) return x.rightLink;
            if(x.rightLink == null) return x.leftLink;
            Node t = x;
            x = min(t.rightLink);
            x.rightLink = deleteMin(t.rightLink);
            x.leftLink = t.leftLink;
        }
        x.size = 1 + size(x.leftLink) + size(x.rightLink);
        return x;
    }
    public Key min() {
        return min(root).key;
    }
    private Node min(Node x) {
        if(x.leftLink == null) return x;
        else return min(x.leftLink);
    }
    public Key max() {
        return max(root).key;
    }
    private Node max(Node x) {
        if(x.rightLink == null) return x;
        else return max(x.rightLink);
    }
    public Key floor(Key key) {
        if(key == null) return null;
        Node temp = floor(root, key);
        if(temp == null) return null;
        else return temp.key;
    }
    private Node floor(Node x, Key key) {
        if(x == null) return null;
        int comp = key.compareTo(x.key);
        if(comp == 0) return x;
        if(comp < 0) return floor(x.leftLink, key);
        Node t = floor(x.rightLink, key);
        if(t != null) return t;
        else return x;
    }
    public Key ceiling(Key key) {
        Node temp = ceiling(root, key);
        return temp.key;
    }
    private Node ceiling(Node x, Key key) {
        if(x == null) return null;
        int comp = key.compareTo(x.key);
        if(comp == 0) return x;
        if(comp > 0) return ceiling(x.rightLink, key);
        Node t = ceiling(x.leftLink, key);
        if(t != null) return t;
        return x;
    }
    public Key select(int k) {
        if(k < 0 && k >= size()) return null;
        Node temp = select(root, k);
        return temp.key;
    }
    private Node select(Node x, int k) {
        if(x == null) return null;
        int t = size(x.leftLink);
        if(k < t) return select(x.leftLink, k);
        else if(k > t) return select(x.rightLink, k-t-1);
        else return x;
    }




}