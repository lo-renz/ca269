import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.Class;
import java.lang.NullPointerException;

class A {
    public String f_A;
    public String f_B;
}

class B extends A {}

interface X {
    void m_X();
}

class C extends B implements X {
    private String f_C;
    public void m_X() {}
}

public class Reflection {

    static boolean checkField(Class class_obj, String str) {
        boolean ancestor = false;

        // iterating through allt he fields and checking if any match the specified str
        for(Field f: class_obj.getFields()) {
            if(f.equals(null)) {
                ancestor = false;
            }
            else if(f.getName().equals(str)) {
                ancestor = true;
            }
        }

        // iterate to the top most ancestor class
        while(!(class_obj.equals(Object.class))) {
            class_obj = class_obj.getSuperclass();
        }

        // iterate through the fields starting from the top most ancestor class
        // checking if any method match the specified str
        for(Field f: class_obj.getFields()) {
            if(f.equals(null)) {
                ancestor = false;
            }
            else if(f.getName().equals(str)) {
                ancestor = true;
            }
        }
        return ancestor;
    }

    static boolean checkMethod(Class class_obj, String str) {
        boolean ancestor = false;

        // iterating through the all the methods and checking if any match the specified str 
        for(Method m: class_obj.getMethods()) {
            if(m.equals(null)) {
                ancestor = false;
            }
            else if(m.getName().equals(str)) {
                ancestor = true;
            }
        }

        // iterate to the top most ancestor class
        while(!(class_obj.equals(Object.class))) {
            class_obj = class_obj.getSuperclass();
        }

        // iterate through the methods starting from the top most ancestor class
        // checking if any method match the specified str
        for(Method m: class_obj.getMethods()) {
            if(m.equals(null)) {
                ancestor = false;
            }
            else if(m.getName().equals(str)) {
                ancestor = true;
            }
        }
        return ancestor;
    }

    static boolean isClass(Class class_obj) {
        if(class_obj.isInterface()) {
            return false;
        }
        else {
            return true;
        }
    }

    static boolean isInterface(Class class_obj) {
        if(class_obj.isInterface()) {
            return true;
        }
        return false;
    }

    static boolean hasAncestor(Class class_obj, String str) {
        try {
            if(class_obj.isInterface()) { // if the first arg is an interface then set it as null
                class_obj = null;
            }
            boolean ancestor = false;
            for(Class c: class_obj.getInterfaces()) { // gather all the interfaces and iterate through them. If an Interface matches with the str then ancestor is true
                if(c.getName().equals(str)) {
                    ancestor = true;
                }
            }
            while(!(class_obj.equals(Object.class))) { // iterate through the ancestors of the specified class.
                class_obj = class_obj.getSuperclass();
                if(class_obj.isInterface()) { // if a ancestor is an interface and if the interface name is equal to str then ancestor is true
                    if(class_obj.getName().equals(str)) {
                        ancestor = true;
                    }
                }
                else if(class_obj.getName().equals(str)) { // continue iterating through the ancestors and if a ancestor class is equal to the str then ancestor is true.
                    ancestor = true;
                }
            }
            return ancestor;
        } catch (NullPointerException E) { // if the first arg is null then return false
            return false;
        }
    }

    public String WishYouA() {
        return "Happy St. Patrick's Day!";
    }

    public static void main(String[] args) {
        // Test for checkField()
        B b = new B();
        Class xb = b.getClass();
        Reflection.checkField(xb, "f_A");
        //System.out.println(Reflection.checkField(xb, "f_A"));

        // Test for checkMethod()
        C c = new C();
        Reflection.checkMethod(c.getClass(), "m_X");

        // Test for isClass()
        C a = new C();
        Class xa = a.getClass();
        Reflection.isClass(xa);

        // Test for hasAncestor()
        //X c = new C();
        //Reflection.hasAncestor(c.getClass(), "X");
    }
}