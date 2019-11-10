class Solution{
	public static double[] dynamicMedian(double[] arr){
		int n = arr.length;
		double[] medianArray = new double[n];
		int size = 0;
		double median = 0;
		maxPQ<Double> maxPq = new maxPQ(n);
		minPQ<Double> minPq = new minPQ(n);
		for(int i = 0; i < n; i++) {
			if(arr[i] <= median) {
				maxPq.insert(arr[i]);
			} else {
				minPq.insert(arr[i]);
			}
			if(maxPq.size() > minPq.size() + 1) {
				minPq.insert(maxPq.delMax());
			}
			if(minPq.size() > maxPq.size() + 1) {
				maxPq.insert(minPq.delMin());
			}
			if(minPq.size() == maxPq.size()) {
				medianArray[size++] = (minPq.min() + maxPq.max())/2;
				median = medianArray[size - 1];
			} else if(minPq.size() > maxPq.size()) {
				medianArray[size++] = minPq.min();
				median = medianArray[size - 1];
			} else{
				medianArray[size++] = maxPq.max();
				median = medianArray[size - 1];
			}

		}
		return medianArray;
	}
}