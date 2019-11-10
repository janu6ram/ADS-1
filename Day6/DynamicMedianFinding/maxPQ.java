public class maxPQ<Item extends Comparable<Item>> {
    private Item[] pq;
    private int n;
    public maxPQ() {
        pq = (Item[]) new Comparable[10];
        n = 0;
    }
    public maxPQ(int size) {
        pq = (Item[]) new Comparable[size];
        n = 0;
    }
    public void insert(Item item) {
        if(n == pq.length - 2) resize();
        pq[++n] = item;
        swim(n);
    }
    public int size() {
        return n;
    }
    public void resize() {
        Item[] temp = (Item[]) new Comparable[2 * n];
        for(int i = 0; i < n; i++) {
            temp[i] = pq[i];
        }
        pq = temp.clone();
    }
    public void swim(int k) {
        while(k > 1 && less(k/2, k)) {
            exch(k/2, k);
            k = k/2;
        }
    }
    public boolean less(int i, int j) {
        int comp = pq[i].compareTo(pq[j]);
        if(comp < 0) return true;
        return false;
    }
    public void exch(int i, int j) {
        Item temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
    public Item delMax() {
        Item max = pq[1];
        exch(1,n);
        n--;
        sink(1);
        return max;
    }
    public Item max() {
        return pq[1];
    }
    public void sink(int k) {
        while(2*k <= n) {
            int j = 2*k;
            if(j < n && less(j,j+1)) j++;
            if(less(j,k)) break;
            exch(j,k);
            k = j;
        }
    }
}