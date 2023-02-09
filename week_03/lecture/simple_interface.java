interface Message {
    String communicate();
}

class simple_interface implements Message {
    public String communicate() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        simple_interface t1 = new simple_interface();
        System.out.println(t1.communicate());
    }
}
