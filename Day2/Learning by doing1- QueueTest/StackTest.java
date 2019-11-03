public class StackTest {
public static void main(String[] args) {
    String str = "it was - the best - of times - - - it was - the - -";
    String[] item = str.split(" ");
    Stack<String> stack = new Stack<String>();
    System.out.println(stack.toString());
    for(int i = 0; i < item.length; i++) {
      if(!item[i].equals("-")) {
        stack.push(item[i]);
      } else {
        System.out.println(stack.pop() + " ");
      }
    }
    System.out.println("(" + stack.size() + " left on stack)");
  }
}