import java.util.Arrays;
public class NumberPairs {
    public static void main(String[] args) {
        int[] arr = new int[args.length];
        for(int i = 0; i < args.length; i++){
            arr[i] = Integer.parseInt(args[i]);
        }
        Arrays.sort(arr);
        int count = 0;
        for(int i = 0; i < arr.length - 1; i++) {
            if(arr[i] == arr[i+1]) {
                count += 1;
            }
        }
        System.out.println(count);
    }
}