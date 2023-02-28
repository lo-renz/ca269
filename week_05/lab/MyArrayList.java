import java.util.Stack;

public class MyArrayList {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String source = "12345";
        String target = "";
        for(Character c: source.toCharArray()) {stack.push(c); }
        while(!stack.empty()) {target += stack.pop(); }

        System.err.println(stack);
        System.out.println(target);
    }
}