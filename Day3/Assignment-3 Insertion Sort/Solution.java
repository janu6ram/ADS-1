class Solution {
	public int[] sortInsertion(int[] arr) {
		// fill you code Here
		for(int i = 0; i < arr.length; i++) {
			for(int j = i; j > 0; j--) {
				if(arr[j] < arr[j-1]) {
					exchange(arr, j, j-1);
				}
			}
		}
		return arr;
	}
	public int[] sortSelection(int[] arr) {
		// fill you code Here
		for(int i = 0; i < arr.length; i++) {
			int min = i;
			int minIndex = min(arr, min);
			exchange(arr, i, minIndex);
		}
		return arr;
	}
	public static int min(int arr[], int min) {
		for(int j = min+1; j < arr.length; j++) {
			if(arr[j] < arr[min]) {
				min = j;
			}
		}
		return min;
	}
	public static void exchange(int[] arr, int i, int minIndex) {
		int temp = arr[i];
		arr[i] = arr[minIndex];
		arr[minIndex] = temp;
	}
}