import java.util.Scanner;

public class Alarm {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter a valid time: ");
        int hour = input.nextInt();
        int min = input.nextInt();

        System.out.println((hour * 60) + min);
    }
}