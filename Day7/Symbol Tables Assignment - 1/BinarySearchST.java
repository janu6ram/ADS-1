class BinarySearchST<Key extends Comparable<Key>,Value> {
    Key[] keys = (Key[]) new Comparable[20];
    int n = 0;
    Value[] values = (Value[]) new Object[20];

    public void put (Key k, Value v) {
        int i = rank(k);
        if(i < n && keys[i].compareTo(k) == 0) {
            values[i] = v;
            return;
        }
        if(n == keys.length) resize();
        for(int j = n; j > i; j--) {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = k;
        values[i] = v;
        n++;
    }
    public void resize() {
        Key[] keys1 = (Key[]) new Comparable[2 * n];
        Value[] values1 = (Value[]) new Object[2 * n];
        for(int i = 0; i < n; i++) {
            keys1[i] = keys[i];
            values1[i] = values[i];
        }
        keys = keys1.clone();
        values = values1.clone();
    }
    public boolean contains(Key k) {
        return (get(k) != null);
    }
    public Value get(Key k) {
        int i = rank(k);
        if(i < n && keys[i].compareTo(k) == 0) {
            return values[i];
        }
        return null;
    }
    public int rank(Key key) {
        if(isEmpty()) return 0;
        int lo = 0;
        int hi = n-1;
        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            int comp = key.compareTo(keys[mid]);
            if(comp < 0) hi = mid - 1;
            else if(comp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }
    public Key max() {
        if(isEmpty()) return null;
        return keys[n-1];
    }
    public Key floor(Key key) {
        int i = rank(key);
        if(isEmpty()) return null;
        if(i < n && keys[i].compareTo(key) == 0) {
            return keys[i];
        } else {
            return keys[i - 1];
        }
    }
    public void deleteMin() {
        if(isEmpty()) return;
        for(int i = 0; i< n-1; i++) {
            keys[i] = keys[i+1];
            values[i] = values[i+1];
        }
        n--;
    }
    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for(int i = 0; i < n; i++) {
            queue.Enqueue(keys[i]);
        }
        return queue;
    }
    public boolean isEmpty() {
        return n == 0;
    }
    // public String toString() {
    //     String res = "";
    //     for(int i = 0; i < n; i++){
    //         res += keys[i] + " ";
    //     }
    //     return res;
    // }
}
