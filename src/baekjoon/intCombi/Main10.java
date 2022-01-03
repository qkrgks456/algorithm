package baekjoon.intCombi;

import java.util.HashMap;
import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int n1 = scanner.nextInt();
            HashMap<String, String> map = new HashMap<>();
            for (int j = 0; j < n1; j++) {
                String s = scanner.nextLine();
                String[] strings = s.split(" ");
                map.put(strings[1], strings[0]);
            }
            System.out.println(map);
            // 여기서 부터 하면되는데 ..
        }
    }
}
