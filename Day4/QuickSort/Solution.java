class Solution{
	public static int[] quickSort(int[] arr){
		// fill you code Here
		sort(arr, 0, arr.length - 1);
		return arr;
	}
	public static void sort(int[] arr, int lo, int hi) {
		if(hi <= lo) return;
		int j = partition(arr, lo, hi);
		sort(arr, lo, j - 1);
		sort(arr, j+1, hi);
	}
	public static int partition(int[] arr, int lo, int hi) {
		int i = lo;
		int j = hi + 1;
		while(true) {
			while(less(arr[++i], arr[lo])) {
				if(i == hi) break;
			}
			while(less(arr[lo], arr[--j])) {
				if(j == lo) break;
			}
			if(i >= j) break;
			exch(arr, i, j);
		}
		exch(arr, lo, j);
		return j;
	}
	public static boolean less(int i, int j) {
		if(i < j) return true;
		return false;
	}
	public static void exch(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
	// public static void main(String[] args) {
	// 	String[] arr1 =
	// }
}