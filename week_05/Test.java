class Template<T> { // <> means generics, T as parameter
    public Template(T t) {
        System.out.println(t);
    }

    void print(Object obj) {
        System.out.println(obj);
    }
}

class A {
    public String toString() {
       return "A";
    }
}

class B {
    public String toString() {
       return "B";
    }
}

class C {
    public String toString() {
       return "C";
    }
}

class Test {
    public static void main(String[] args) {
        Template<Integer> a = new Template<Integer>(42);
        Template<String> b = new Template<String>("Hello, World!");
    }
}
