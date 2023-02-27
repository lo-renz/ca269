import java.util.Scanner;

public class Age {
    public static void main(String[] args) {
        System.out.print("Age: ");
        Scanner input = new Scanner(System.in);
        int age = input.nextInt();

        if(age < 18 && age >= 65) {
            System.out.println("You are not within the permitted employment age");
        }
        else {
            System.out.println("You are within the permitted employment age");
        }
    }
}