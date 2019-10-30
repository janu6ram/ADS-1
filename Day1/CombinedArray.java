import java.util.Arrays;

public class CombinedArray {
    /**
     * main method
     * in this program merged two sorted arrays.
     * but the condition is sort the element before adding
     * to the combined array.
     * @param args main
     */
    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 17};
        int[] brr = {3, 10, 15, 20, 25};
        int[] crr = new int[arr.length + brr.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while (i < arr.length && j < brr.length) {
            if (arr[i] < brr[j]) {
                crr[index++] = arr[i++];
            } else {
                crr[index++] = brr[j++];
            }
        }
        while (i < arr.length) {
            crr[index++] = arr[i++];
        }
        while (j < arr.length) {
            crr[index++] = brr[j++];
        }
        System.out.println("Our merged array is :");
        System.out.println(Arrays.toString(crr));
    }

}
