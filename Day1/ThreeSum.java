import java.util.Arrays;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {40,0,-40,10,20,-10,-20,15,5,16,14};
        int count = 0;
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                int find = -(arr[i] + arr[j]);
                //System.out.println(find);
                int index = Arrays.binarySearch(arr,find);
                //System.out.println("index is " + index);
                if(i < j && j < index) {
                    count +=1;
                    //System.out.println("count is " + count);
                }
            }
        }
        System.out.println(count);
    }
}