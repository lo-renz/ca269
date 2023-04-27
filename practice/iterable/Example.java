import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Example {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");

        Iterator<String> iter = list.iterator();

        while(iter.hasNext()) {
            String item = iter.next();
            System.out.println(item);
        }
    }
}
