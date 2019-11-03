class Solution{
	public static String isMatching(String str){
		// fill you code Here
		Stack<String> stack = new Stack<String>();
		String[] arr = str.split("");
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals("{") || arr[i].equals("[") || arr[i].equals("(")) {
				stack.push(arr[i]);
			} else {
				if(i==0 || !((arr[i].equals(")") && stack.pop().equals("(")) ||
				(arr[i].equals("]") && stack.pop().equals("[")) ||
				(arr[i].equals("}") && stack.pop().equals("{")))) {
					return "NO";
				}
			}
		}
		if (!stack.isEmpty()) return "NO";
		return "YES";
	}
}