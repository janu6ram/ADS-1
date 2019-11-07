class Solution{
	public static boolean isMinHeap(double[] arr) {
		if(arr.length == 0) return false;
		if(arr.length == 1) return true;
		if(arr.length == 2) {
			if(arr[0] <= arr[1]) return true;
			else return false;
		}
		for(int i = 0; i <= (arr.length/2) - 2; i++) {
			if(arr[i] > arr[(2 * i) + 1] || arr[i] > arr[(2 * i) + 2]) {
				return false;
			}
		}
		return true;
	}
}