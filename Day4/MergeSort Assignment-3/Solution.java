class Solution{
	public static String[] mergeSort(String[] arr) {
		// fill you code Here
		String[] aux = new String[arr.length];
		sort(arr, aux, 0, arr.length - 1);
		return arr;
	}
	public static void sort(String[] arr, String[] aux, int lo, int hi) {
		if(hi <= lo) return;
		int mid = lo + (hi - lo)/2;
		sort(arr, aux, lo, mid);
		sort(arr, aux, mid + 1, hi);
		merge(arr, aux, lo, mid, hi);
	}
	public static void merge(String[] arr, String[] aux, int lo, int mid, int hi) {
		for(int k = lo; k <= hi; k++) {
			aux[k] = arr[k];
		}
		int i = lo;
		int j = mid + 1;
		for(int k = lo; k <= hi; k++) {
			if(i > mid) arr[k] = aux[j++];
			else if(j > hi) arr[k] = aux[i++];
			else if(less(aux[j], aux[i])) arr[k] = aux[j++];
			else arr[k] = aux[i++];
		}
	}
	public static boolean less(String j, String i) {
		int comp = j.compareTo(i);
		if(comp < 0) return true;
		return false;
	}
	// public static void main( String[] args) {
	// 	String[] arr1 = {"the", "of", "and", "to", "a", "in", "for", "is", "on", "that"};
	// 	String[] arr2 = mergeSort(arr1);
	// 	System.out.println(Arrays.toString(arr2));

	// }
}