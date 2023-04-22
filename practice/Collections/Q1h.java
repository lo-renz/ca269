import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

class MakeMap {
    static MAp<String, Integer> makeMap(Scanner scan) {
        Map<String, Integer> map = new HashMap<>():
        while(map.hasNext()) {
            map.put(scan.next(), scan.nextInt());
        }
        return map;
    }
}
