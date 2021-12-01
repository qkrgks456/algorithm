package hashtree;

import java.util.HashMap;
import java.util.Scanner;

public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String str = scanner.next();
        HashMap<String, Integer> map = new HashMap<>();
        char[] chars = str.toCharArray();
        map.put("A", 0);
        map.put("B", 0);
        map.put("C", 0);
        map.put("D", 0);
        map.put("E", 0);
        for (char c : chars) {
            if (c == 'A') {
                int a = map.get("A");
                a++;
                map.put("A", a);
            } else if (c == 'B') {
                int a = map.get("B");
                a++;
                map.put("B", a);
            } else if (c == 'C') {
                int a = map.get("C");
                a++;
                map.put("C", a);
            } else if (c == 'D') {
                int a = map.get("D");
                a++;
                map.put("D", a);
            } else {
                int a = map.get("E");
                a++;
                map.put("E", a);
            }
        }
        int max = map.get("A");
        String s = "A";
        for (String key : map.keySet()) {
            if (max < map.get(key)) {
                max = map.get(key);
                s = key;
            }
        }
        System.out.println(s);
    }
}
