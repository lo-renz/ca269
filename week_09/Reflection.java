import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.Class;
import java.lang.NoSuchMethodException;

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
        for(Field f: class_obj.getFields()) {
            if(f.getName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    static boolean checkMethod(Class class_obj, String str) {
        for(Method m: class_obj.getMethods()) {
            if(m.getName().equals(str)) {
                return true;
            }
        }
        return false;
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
        boolean ancestor = false;
        if(class_obj.getName().equals(str)) {
            ancestor = false;
        }
        else {
            while(!(class_obj.equals(Object.class))) {
                if(class_obj.getName().equals(str)) {
                    ancestor = true;
                }
                class_obj = class_obj.getSuperclass();
            }
        }
        return ancestor;
    }

    public String WishYouA() {
        return "Happy St. Patrick's Day!";
    }

    public static void main(String[] args) {
        // Test for checkField()
        B b = new B();
        Class xb = b.getClass();
        Reflection.checkField(xb, "f_A");

        // Test for isClass()
        C a = new C();
        Class xa = a.getClass();
        Reflection.isClass(xa);

        // Test for hasAncestor()
        C c = new C();
        Reflection.hasAncestor(c.getClass(), "C");
    }
}