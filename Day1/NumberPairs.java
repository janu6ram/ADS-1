import java.util.Arrays;
/**
 * this program is for getting number pairs
 * in array.
 * for example [1,2,2,3,3,4,5]
 * the above array has twopairs then output
 * will be two.
 * And the time complexity is
 * for reading input N
 * for sorting NlogN
 * for finding pairs N
 * for approximation we get NlogN
 */
public class NumberPairs {
    /**
     * this is the main method.
     * take input from main args[].
     * the elements in string array args are
     * converted into integers using parseint.
     * @param args input.
     * then sorted the array using Arrays.sort.
     */
    public static void main(String[] args) {
        int[] arr = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            arr[i] = Integer.parseInt(args[i]);
        }
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                count += 1;
            }
        }
        System.out.println(count);
    }
}
