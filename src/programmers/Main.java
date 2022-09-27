package programmers;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Map<Integer, Point> map = new HashMap<>();
        int num = 0;
        for (int i = 1; i < 9; i += 3) {
            map.put(i, new Point(num, 0));
            map.put(i + 1, new Point(num, 1));
            map.put(i + 2, new Point(num, 2));
            num++;
        }
        System.out.println(map);
    }

    public static int numCount(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) count++;
            else if (n % i == 0) count += 2;
        }
        return count;
    }
}

