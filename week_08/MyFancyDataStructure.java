import java.util.*;

//interface Comparable<T> {
//    public int compareTo(T other);
//}

//interface Comparator<T> {
//    public int compare(T o1, T o2);
//}

class Value implements Comparable<Value> {
    final int value;

    public int getValue() {
        return this.value;
    }

    Value(int value) {
        this.value = value;
    }

    public String toString() {;
        String message = "";
        message += getValue();
        return message;
    }

    static private boolean SORT_LOWER;

    /** 
    * Given a list [2, 3, 1]:
    * if SORT_LOWER == true, the sorted list should be [1, 2, 3]
    * if SORT_LOWER == false, the sorted list should be [3, 2, 1]
    */

    static public boolean isSortLower() {
        Value.SORT_LOWER = true;
        return Value.SORT_LOWER;
    }

    static public boolean isSortHigher() {
        Value.SORT_LOWER = false;
        return Value.SORT_LOWER;
    }

    static public void setSortLower() {
        Value.SORT_LOWER = true;
    }

    static public void setSortHigher() {
        Value.SORT_LOWER = false;
    }

    public int compareTo(Value other) {
        if(Value.SORT_LOWER == true) {
            return Integer.compare(this.value, other.value);
        }
        else if(Value.SORT_LOWER == false) {
            return Integer.compare(other.value, this.value);
        }
        return 0;
    }
}

class PreferLowerValues implements Comparator<Value> {
    public int compare(Value o1, Value o2) {
        return Integer.compare(o1.value, o2.value);
    }
}

class PreferHigherValues implements Comparator<Value> {
    public int compare(Value o1, Value o2) {
        return Integer.compare(o2.value, o1.value);
    }
}

public class MyFancyDataStructure {
    public static void main(String[] args) {
        List<Value> list = Arrays.asList(new Value(2), new Value(3), new Value(1));

        Value.setSortLower();
        Collections.sort(list);
        System.out.println(list);
        // OUTPUT: [1, 2, 3]

        Value.setSortHigher();
        Collections.sort(list);
        System.out.println(list);
        // OUTPUT: [3, 2, 1]

        list.sort(new PreferLowerValues());
        System.out.println(list);
        // OUTPUT: [1, 2, 3]

        list.sort(new PreferHigherValues());
        System.out.println(list);
        // OUTPUT: [3, 2, 1]
    }
}
