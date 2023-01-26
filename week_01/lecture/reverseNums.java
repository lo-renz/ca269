import java.util.Scanner;

public class reverseNums
{
    public static void main(String[] args)
    {
        int[] counts = new int[10];
        System.out.println("Enter 10 numbers: ");

        for(int i = 0; i < counts.length; ++i)
        {
            counts[i] = in.nextInt();
        }

        for(int i = counts.length; i >= 0; i--)
        {
            System.out.println(counts[i] + " ");
        }
    }
}
