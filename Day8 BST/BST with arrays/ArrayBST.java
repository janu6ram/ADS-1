import java.util.Arrays;

public class ArrayBST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int[] size;
    private int n;
    public ArrayBST() {
        keys = (Key[]) new Comparable[30];
        values = (Value[]) new Object[30];
        int n = 0;
        size = new int[20];
    }
    public void put(Key key, Value value) {
        if(key == null) return;
        if(value == null) return;
        int i = 1;
        while(keys[i] != null) {
            int comp = key.compareTo(keys[i]);
            if(comp > 0) {
                i = (2 * i + 1);
            } else if(comp < 0) {
                i = 2 * i;
            } else {
                values[i] = value;
                return;
            }
        }
        keys[i] = key;
        values[i] = value;
        n++;
    }
    public int size(int i) {
        int left = 0;
        int right = 0;
        if(keys[2*i +1] != null) right = 1;
        if(keys[2*i] != null) left = 1;
        size[i] = left * (size[2*i]) + right * (size[2*i + 1]) + 1;
        return size[i];
    }
    private void sizeArray() {
        for(int i = 1; i < n; i++) {
            size[i] = size(i);
        }
    }
    public Value get(Key key) {
        // System.out.println(Arrays.toString(keys));
        // System.out.println(Arrays.toString(values));
        for(int i = 1; i <= keys.length; i++) {
            if(keys[i] == null) continue;
            if(key.compareTo(keys[i]) == 0) {
                return values[i];
            }
        }
        return null;
    }
}