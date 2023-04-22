import java.util.Queue;
import java.util.LinkedList;

class GenericQueue {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<String>();
        queue.add("one");
        queue.add("two");
        queue.remove(); // "one" is removed from the head
        queue.remove(); // "two" is removed from the head
        queue.remove(); // error - queue is empty
        queue.poll(); // no error, returns null if queue is empty, otherwise head
        queue.peek() // retrieves head but doesn't remove it, error if queue is empty
        queue.isEmpty(); // returns true/false if queue is empty
    }
}
