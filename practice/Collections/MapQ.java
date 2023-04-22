import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

class Answer {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        Scanner scan = new Scanner(System.in);

        while(scan.hasNext()) {
            String key = scan.next();
            if(map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
            System.out.println(map);
        }
    }
}
