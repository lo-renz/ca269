import java.util.Scanner;

public class HelloWorld {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Name: ");
        String name = input.nextLine();

        int vowel_counter = 0;
        char[] name_chars = name.toCharArray();
        for(int i = 0; i < name_chars.length; i++) {
            switch(name_chars[i]) {
                case 'a':
                    vowel_counter += 1;
                    break;
                case 'e':
                    vowel_counter += 1;
                    break;
                case 'i':
                    vowel_counter += 1;
                    break;
                case 'o':
                    vowel_counter += 1;
                    break;
                case 'u':
                    vowel_counter += 1;
                    break;
                }
        }

        System.out.println("There are "+vowel_counter+" in your name.");
    }
}