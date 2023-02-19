import java.util.Scanner;

public class VowelAge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String name = input.nextLine();
        int age = input.nextInt();

        int vowel_counter = 0;
        char[] name_chars = name.toLowerCase().toCharArray();
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

        if(age < 18) {
            System.out.println("Hello "+name+", you have "+vowel_counter+" vowels, and you are a minor");
        }
        else {
            System.out.println("Hello "+name+", you have "+vowel_counter+" vowels, and you are an adult");
        }
    }
}