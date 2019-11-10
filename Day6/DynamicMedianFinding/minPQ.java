public class minPQ<Item extends Comparable<Item>> {
    private Item[] pq;
    private int n;
    public minPQ() {
        pq = (Item[]) new Comparable[10];
        n = 0;

    }
    public minPQ(int size) {
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
        while(k > 1 && greater(k/2, k)){
            exch(k,k/2);
            k = k/2;
        }
    }
    public void exch(int i, int j) {
        Item temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }
    public boolean greater(int i, int j) {
        int comp = pq[i].compareTo(pq[j]);
        if(comp > 0) return true;
        return false;
    }
    public Item delMin() {
        Item min = pq[1];
        exch(1,n);
        n--;
        sink(1);
        return min;
    }
    public Item min() {
        return pq[1];
    }
    public void sink(int k) {
        while(2*k <= n) {
            int j = 2*k;
            if(j < n && greater(j, j+1)) j++;
            if(greater(j, k)) break;
            exch(k, j);
            k = j;
        }
    }

}