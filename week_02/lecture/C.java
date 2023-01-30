class C {
    // nested classes!
    // don't do this though -
    // its ugly unless required
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

    public static void main(String args[]) {
        C c = new C();
        // cat.new ...
        // Look at this weird syntax because of nested classes
        P instance = c.new P();
        instance.print();
        instance = c.new X();
        instance.print();
        instance = c.new Y();
        instance.print();
    }
}

// prints P X Y
// correctly calling the print() method associated with each class
