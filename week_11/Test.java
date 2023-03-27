import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

class Test {
    public static void main(String args[]) {
        BufferedReader in = new BufferedReader(new FileReader("input.txt"));
        BufferedWriter out = new BufferedWriter(new FileWriter("output.txt"));

        String line = in.readLine();
        StringTokenizer tokenize = new StringTokenizer(line);
        int x = Integer.parseInt(tokenize.nextToken());
    }
}