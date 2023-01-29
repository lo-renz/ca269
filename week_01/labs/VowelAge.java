import java.util.Scanner;

public class VowelAge {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String name = input.nextLine();
        int age = input.nextInt();

        //System.out.println(name);
        //System.out.println(age);

        int no_of_vowels = 0;

        char[] name_chars = name.toLowerCase().toCharArray();
        for(int i = 0; i < name.length(); ++i) {

            switch(name_chars[i]) {
                case 'a':
                    no_of_vowels += 1;
                    break;
                case 'e':
                    no_of_vowels += 1;
                    break;
                case 'i':
                    no_of_vowels += 1;
                    break;
                case 'o':
                    no_of_vowels += 1;
                    break;
                case 'u':
                    no_of_vowels += 1;
                    break;
            }

        }
        //System.out.println(no_of_vowels);
        if(age < 18) {
            System.out.println("Hello " + name + ", you have " + no_of_vowels + " vowels, and you are a minor");
        }
        else {
            System.out.println("Hello " + name + ", you have " + no_of_vowels + " vowels, and you are an adult");
        }
    }
}
