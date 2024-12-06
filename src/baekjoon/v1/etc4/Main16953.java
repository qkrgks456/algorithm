package baekjoon.v1.etc4;

import java.util.*;

public class Main16953 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n1 = scanner.nextInt();
        long n2 = scanner.nextInt();
        Queue<Long> queue = new LinkedList<>();
        Map<Long, Integer> map = new HashMap<>();
        queue.add(n1);
        map.put(n1, 0);
        while (!queue.isEmpty()) {
            long num = queue.poll();
            if (num == n2) {
                System.out.println(map.get(num) + 1);
                System.exit(0);
            }
            String s = String.valueOf(num);
            s += 1;
            long n = Long.valueOf(s);
            if (n < 1000000000) {
                if (map.get(n) == null) {
                    map.put(n, map.get(num) + 1);
                    queue.add(n);
                }
            }
            if (num * 2 <= 1000000000) {
                if (map.get(num * 2) == null) {
                    map.put(num * 2, map.get(num) + 1);
                    queue.add(num * 2);
                }
            }
        }
        System.out.println(-1);
    }
}
