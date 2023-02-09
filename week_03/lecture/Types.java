class A {}
class B extends A {}
class C extends B {}

public class Types {
    public static void main(String[] args) {
        C c = (C) new C(); // redundant cast
        System.out.println("casting C to (C) has: " + c.getClass()); // --> C
        B b = (B) new C();
        System.out.println("casting C to (B) has: " + b.getClass()); // --> C
        A a = new C();
        System.out.println("casting C to (A) has: " + a.getClass()); // --> C

        B c1 = new B();
        System.out.println("casting B to (B) has: " + c1.getClass());

        System.out.println("C.class: " + C.class); // class C

        System.out.println("instance of C is instance of C? " + (c instanceof C)); // True
            // Note that == can be used for an instance of a class...
            // but just because it works, don't rely on it
            // ALWAYS use .equals
        System.out.println("c.getClass() == C.class? " + c.getClass().equals(C.class)); // True
            // using == after this will raise errors.
        System.out.println("instance of C is instance of B? " + (c instanceof B)); // true
        System.out.println("c.getClass() == B.class? " + c.getClass().equals(B.class)); // false
        System.out.println("instance of C is instance of A? " + (c instanceof A)); // true
        System.out.println("c.getClass() == A.class? " + c.getClass().equals(A.class)); // false
        System.out.println("instance of C is instance of Object? " + (c instanceof Object)); // true
        System.out.println("c.getClass() == Object.class? " + c.getClass().equals(Object.class)); // false
    }
}
