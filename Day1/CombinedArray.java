import java.util.Arrays;
/**
 * This program is to merge two arrays after
 * sorting.
 * condition is the time complexity in worst
 * case must be N.
 */
public class CombinedArray {
    /**
     * crr is an empty array in which two
     * arrays must be merged.
     */
    private static int[] crr;
    /**
     * main method.
     * Here two sorted arrays are taken as input
     * and call the mergesort method.
     * @param args main
     */
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 17};
        int[] brr = {3, 10, 15, 20, 25};
        mergeSort(arr, brr);
        System.out.println("Our merged array is :");
        System.out.println(Arrays.toString(crr));
    }
    /**
     * this method is to merge two arrays.
     * while merging sort element and added to new array crr.
     * this method has two parameters.
     * @param arr first sorted array.
     * @param brr second sorted array.
     */
    private static void mergeSort(final int[] arr, final int[] brr) {
        crr = new int[arr.length + brr.length];
        int index = 0;
        int i = 0;
        int j = 0;
        // this loop time complexity is N.
        while (i < arr.length && j < brr.length) {
            if (arr[i] < brr[j]) {
                crr[index++] = arr[i++];
            } else {
                crr[index++] = brr[j++];
            }
        }
        // this loop time complexity also N.
        // to add remaining elements of arr.
        while (i < arr.length) {
            crr[index++] = arr[i++];
        }
        // this loop time complexity also N.
        // to add remaining elements of arr.
        while (j < brr.length) {
            crr[index++] = brr[j++];
        }
    }
}
