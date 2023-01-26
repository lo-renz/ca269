public class ex1
{
    public static void main(String[] args)
    {
        char[] arrayChar = new char[4];
        arrayChar[0] = 'C';
        arrayChar[3] = 'K';
        arrayChar[2] = 'Z';
        arrayChar[1] = 'W';

        for(int i = 0; i < arrayChar.length; ++i)
        {
            System.out.print("-" + arrayChar[i]);
        }
    }
}
