public class myNum {

    public static void main(String[] args) {
        int myNum = 10;
        System.out.println(myNum);

        float myFloatNum = 5.99f;
        System.out.println(myFloatNum);

        char myLetter = 'R';
        System.out.println(myLetter);

        boolean myBool = true;
        System.out.println(myBool);

        String myText = "Hi";
        System.out.println(myText);

        int i;
        double x = 3.0;
        i = (int) (10.3 * x);
        System.out.println(i);

        String str = "Hello";
        System.out.println(str);

        str = new String("Hello World");
        System.out.println(str);

        /***
        int scores[];
        *scores = new int[7];
        *scores[0] = 5;
        *scores[1] = scores[0] * 10;
        *scores[2] = 123;
        *scores[3] = 3;
        *scores[4] = 23;
        *scores[5] = 1;
        *scores[6] = 12;
        */

        int[] scores = {1, 2, 3, 4, 5, 6, 7};

        System.out.println(scores[0]);
        System.out.println(scores[1]);

        double [] prices = new double[2];
        prices[0] = 1.2;
        prices[1] = 1.5;
        System.out.println(prices[0]);
    }

}
