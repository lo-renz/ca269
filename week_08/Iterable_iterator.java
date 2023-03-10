import java.util.ArrayList;
import java.util.Iterator;

public class Iterable_iterator {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        // get an iterator to traverse the list
        Iterator<String> iter = list.iterator();

        // iterate one item at a time
        while(iter.hasNext()) {
            String item = iter.next();
            System.out.println(item);
        }

        for(String i: list) {
            System.out.println(i);
        }
    }
}