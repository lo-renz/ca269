import java.util.Set;
import java.util.HashSet;

class GenericSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        set.add("one");
        System.out.println(set);
        set.add("one");
        set.remove("one");
        System.out.println(set);
        set.remove("two");
        set.isEmpty();
    }
}
