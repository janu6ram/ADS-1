class Solution{
	public static String[] mergeSort(String[] arr) {
		// fill you code Here
		if(arr.length >= 2) {
			String[] left = new String[arr.length/2];
			String[] right = new String[arr.length - arr.length/2];
			for(int i = 0; i < left.length; i++) {
				left[i] = arr[i];
			}
			for(int i = 0; i < right.length; i++) {
				right[i] = arr[i + arr.length/2];
			}
			mergeSort(left);
			mergeSort(right);
			merge(arr, left, right);
		 }
		 return arr;
	}
	public static void merge(String[] arr, String[]left,
		String[]right) {
			int a = 0;
			int b = 0;
			for (int i = 0; i < arr.length; i++) {
				if (b >= right.length || (a < left.length
				&& left[a].compareToIgnoreCase(right[b]) < 0)) {
					arr[i] = left[a];
					a++;
				} else {
					arr[i] = right[b];
					b++;
				}
			}

	}

}