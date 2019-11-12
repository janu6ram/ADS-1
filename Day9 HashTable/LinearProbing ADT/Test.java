public class Test {
    public static void main(String[] args) {
        LinearProbingHashST<String, Integer> HashST  = new LinearProbingHashST(5);
        HashST.put("prem", 109);
        HashST.put("ravi", 4);
        HashST.put("abhiram", 20);
        HashST.put("vamsi", 118);
        HashST.put("srikar", 74);
        HashST.put("venugopal", 12);
        System.out.println(HashST.get("vamsi"));
        System.out.println(HashST.get("prem"));
        HashST.delete("prem");
        HashST.display();
    }
}