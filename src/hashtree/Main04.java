package hashtree;

import java.util.HashMap;
import java.util.Scanner;

public class Main04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char c : chars2) {
            if (map2.containsKey(c)) {
                int n = map2.get(c);
                n++;
                map2.put(c, n);
            } else {
                map2.put(c, 1);
            }
        }
        int lt = 0;
        int rt = 0;
        int result = 0;
        while (rt < str1.length()) {
            if (lt + str2.length() == rt) {
                int n2 = map1.get(chars1[lt]);
                n2--;
                if (n2 == 0) {
                    map1.remove(chars1[lt]);
                } else {
                    map1.put(chars1[lt], n2);
                }
                lt++;
            }
            if (map1.containsKey(chars1[rt])) {
                int n = map1.get(chars1[rt]);
                n++;
                map1.put(chars1[rt], n);
            } else {
                map1.put(chars1[rt], 1);
            }
            if (map1.equals(map2)) {
                result++;
            }
            rt++;
        }
        System.out.println(result);
    }
}
