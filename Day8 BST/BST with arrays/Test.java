public class Test {
    public static void main(String[] args) {
        ArrayBST<String, Integer> binaryST = new ArrayBST();
        binaryST.put("prem", 109);
        binaryST.put("ravi", 4);
        binaryST.put("abhiram", 20);
        binaryST.put("vamsi", 118);
        binaryST.put("srikar", 74);
        binaryST.put("venugopal", 12);
        System.out.println(binaryST.get("vamsi"));
        System.out.println(binaryST.get("prem"));
    }
}