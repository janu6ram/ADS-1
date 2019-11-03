public class Solution {
	public static String Josephus(int a, int b){
		Queue<Integer> queue = new Queue<Integer>();
		// fill you code Here
		for(int i = 0; i < a; i++) {
			queue.Enqueue(i);
		}
		int item = 0;
		String str = "";
		int count = 0;
		while(queue.size() != 1) {
			item = queue.Dequeue();
			count++;
			if (count != b) {
				queue.Enqueue(item);
			}
			if (count == b) {
				str += item + " ";
				count = 0;
			}
		}
		item = queue.Dequeue();
		return str + item;
	}
}