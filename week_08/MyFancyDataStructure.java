interface Comparable {
    public int compareTo(Object other);
}

class Value {
    final int value;
    public String message = "";

    public int getValue() {
        return this.value;
    }

    Value(int value) {
        this.value = value;
    }

    public String toString() {;
        message += getValue();
        return message;
    }
}

public class MyFancyDataStructure {
    public static void main(String[] args) {
        Value x = new Value(10);
        System.out.println(x);
    }
}