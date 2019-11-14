import java.util.Scanner;
public class RansomNote {
    public static void main(String[] args) {
        SeparateChainingHashST<String, Integer> hashST = new SeparateChainingHashST(20);
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter the magzine");
        String[] magzine = scan.nextLine().split(" ");
        System.out.println("Please enter the ranson Note");
        String [] ransomNote = scan.nextLine().split(" ");
        for(int i = 0; i < magzine.length; i++) {
            if(hashST.get(magzine[i]) == null) {
                hashST.put(magzine[i], 1);
            } else {
                int value = hashST.get(magzine[i]) + 1;
                hashST.put(magzine[i], value);
            }
        }
        int count = 0;
        for(int i = 0; i < ransomNote.length; i++) {
            if(hashST.get(ransomNote[i]) != null) count += 1;
        }
        if(ransomNote.length == count) {
            System.out.println("yes, it is correct");
        } else {
            System.out.println("No, it is not correct");
        }
    }
}