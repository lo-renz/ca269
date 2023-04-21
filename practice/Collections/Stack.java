import java.util.List;
import java.util.Stack;

class GenericStack {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();

        for(int i=1; i<=10; i++) {
            stack.push(i);
        }

        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.pop());
        System.out.println(stack);

        /*while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }*/
    }
}
