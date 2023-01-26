import java.util.Scanner;

public class readingNums
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int [] scores = new int[10];

        System.out.println("Enter 10 scores: ");
        for(int i = 0; i < scores.length; i++)
            scores[i] = in.nextInt();

        for(int i = 0; i < scores.length; ++i)
            System.out.println(i + ": " + scores[i]);

        //System.out.print("\n"); // Just to get rid of the percentage symbol at the end of the print.
        //System.out.println(scores.length);
    }

}
