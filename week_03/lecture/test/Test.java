abstract class Hello {
    public void hi() {
        System.out.println("Hello World!");
    }
}

class World extends Hello {}

public class Test {
    String hello = "hello";

    public String toString() {
        return hello;
    }

    public static void main(String[] args) {
        Test t1 = new Test();
        System.out.println(t1);

        World w = new World();
        w.hi();
    }
}
