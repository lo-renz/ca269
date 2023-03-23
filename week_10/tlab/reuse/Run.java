package reuse;

import test.A;
import test.B;
import test.C;

class Run {
    public static void main(String args[]) {
        System.out.println("We are in Run");
        A.main(args);
        B.main(args);
        C.main(args);
    }
}