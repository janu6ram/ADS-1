import java.util.Arrays;
/**
 * this program is two find the sum of
 * three elements must be zero.
 */
public class ThreeSum {
    /**
     * this variable counts the no of pairs
     * sum in the given array becomes zero.
     */
    private static int count = 0;
    /**
     * Using for loops we get the sum of two numbers
     * and using Arrays.binarySearch(arr,find) find
     * the sum of two numbers in the array.
     * if exists then count will be increased.
     * finally shows the no of pairs.
     * @param args String array.
     */
    public static void main(String[] args) {
        int[] arr = {40, 0, -40, 10, 20, -10, -20, 15, 5, 14};
        Arrays.sort(arr);
        threeSum(arr);
        System.out.println(count);
    }
    /**
     * this method
     * the time complexity of two for loops is N^2.
     * and binary search is logN.
     * then finally it completes with N^2logN.
     * @param arr int array which is our input.
     * @return count, shows how many threesum becomes zero.
     */
    private static int threeSum(final int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int find = -(arr[i] + arr[j]);
                int index = Arrays.binarySearch(arr, find);
                if (i < j && j < index) {
                    count += 1;
                }
            }
        }
        return count;
    }
}
