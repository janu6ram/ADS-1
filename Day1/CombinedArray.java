import java.util.Arrays;

public class CombinedArray {
    public static void main(String[] args) {
        int[] arr = {2,4,5,7,9};
        int[] brr = {3,6,8,9,10};
        int[] crr = new int[arr.length + brr.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while(i < arr.length && j < brr.length) {
            if (arr[i] < brr[j]) {
                crr[index ++] = arr[i ++];
            } else {
                crr[index ++] = brr[j ++];
            }
        }
        while(i < arr.length) {
            crr[index ++] = arr[i ++];
        }
        while(j < arr.length) {
            crr[index ++] = brr[j ++];
        }
        System.out.println("Our merged array is :");
        System.out.println(Arrays.toString(crr));
    }

}