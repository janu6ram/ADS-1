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


}