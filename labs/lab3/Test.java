interface Message {
    String communicate();
}

class Test implements Message {
    public String communicate() {
        return  "Hello, World!";
    }

    String communicate(int number) {
        return "Hello, World!2";
    }

    public static void main(String[] args) {
        Test t1 = new Test();
        System.out.println(t1.communicate());
    }
}