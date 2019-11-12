/**
 * This class represents a symbol table of generic
 * key-value pairs.
 * This implementation uses a linear probing hash table.
 * @param <Key> generic type of keys
 * @param <Value> generic type of values
 * @author janaki ram
 */
public class LinearProbingHashST<Key,Value> {
    private Key[] keys;   // contains all keys
    private Value[] values; // contains all values
    private int n;  // number of key-value pairs
    private int m;  // size of hashtable

    /**
     *Constructor for initializing an empty symbol table.
     */
    public LinearProbingHashST() {
        m = 10;
        n = 0;
        keys = (Key[]) new Object[m];
        values = (Value[]) new Object[m];
    }
    /**
     * Construtor for initializing an empty symbol table
     * with initial specific capacity.
     * @param capacity capacity of array.
     */
    public LinearProbingHashST(int capacity) {
        m = capacity;
        n = 0;
        keys = (Key[]) new Object[m];
        values = (Value[]) new Object[m];
    }

    /**
     *
     * @param key
     * @param value
     */
    public void put(Key key, Value value) {
        if(value == null) {
            delete(key);
        }
        if(n == m/2) resize(2*m);
        int i;
        System.out.println(hash(key));
        for(i = hash(key); keys[i] != null; i = (i+1)% m) {
            if(keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        n++;
    }

    /**
     *  resizes the hash table to the given capacity by re-hashing all of the keys.
     */
    private void resize(int capacity) {
        LinearProbingHashST<Key, Value> temp = new LinearProbingHashST<Key, Value>(capacity);
        for(int i = 0; i < m; i++) {
            if(keys[i] != null) {
                temp.put(keys[i], values[i]);
            }
        }
        keys = temp.keys;
        values = temp.values;
        m = temp.m;
    }

    // hash function for keys - returns value between 0 and M-1.
    private int hash(Key key) {
        return (key.hashCode() & 0x7fffffff) % m;
    }
    public Value get(Key key) {
        int i;
        for(i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if(keys[i].equals(key)) {
                return values[i];
            }
        }
        return null;
    }
    public void delete(Key key) {
        int i;
        for(i = hash(key); keys[i] != null; i = (i + 1) % m) {
            if(keys[i].equals(key)) {
                keys[i] = null;
                values[i] = null;
                break;
            }
        }
        for(int k = i; keys[k] != null;k = (k + 1) % m) {
            Key keyToRehash = keys[k];
            Value valueToRehash = values[k];
            keys[k] = null;
            values[k] = null;
            n--;
            put(keyToRehash, valueToRehash);
        }
        n--;
        if(n> 0 && n <= m/8) resize(m/2);
    }
    public void display() {
        System.out.println(n);
        System.out.println("Hash table contains key-value pairs: {");
        for(int i = 0; i < m; i++) {
            if(keys[i] != null) {
                System.out.println("(" + keys[i].toString() +" "+ values[i].toString() + ")");
            }

        }
        System.out.print(" }");

    }
}