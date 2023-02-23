class C {
    class P {
        void print() {
            System.out.println("P");
        }
    }

    class X extends P {
        void print() {
            System.out.println("X");
        }
    }

    class Y extends P {
        void print() {
            System.out.println("Y");
        }
    }

    public static void main(String[] args) {
        C c = new C();
        P instance = c.new P();
        instance.print();
        instance = c.new X();
        instance.print();
        instance = c.new Y();
        instance.print();
    }
}