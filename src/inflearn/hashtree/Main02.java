package inflearn.hashtree;

import java.util.HashMap;
import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        for (char c : ch1) {
            map.put(c, 0);
        }
        for (char c : ch1) {
            int num = map.get(c);
            num++;
            map.put(c, num);
        }

        for (char c : ch2) {
            map2.put(c, 0);
        }
        for (char c : ch2) {
            int num = map2.get(c);
            num++;
            map2.put(c, num);
        }
        boolean check = true;
        for (char c : map.keySet()) {
            if (map.get(c) != map2.get(c)) {
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
