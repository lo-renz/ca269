import java.util.Stack;

class Q1 {
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<Character>();

        String source = "12345";
        String target = "";

        for(Character c: source.toCharArray()) {
            stack.push(c);
        }

        while(!stack.isEmpty()) {
            target += stack.pop();
        }

        System.out.println(stack);
        System.out.println(target);
    }
}
