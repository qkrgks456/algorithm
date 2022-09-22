package programmers.kakao.test2021;

import java.util.*;

public class Solution2 {
    static int max;
    static char[] check;
    static char[] chars = new char[26];
    static List<Map<String, Integer>> list;
    static List<String> result = new ArrayList<>();

    public String[] solution(String[] orders, int[] course) {
        for (int n : course) {
            max = 0;
            check = new char[n];
            list = new ArrayList<>();
            DFS(orders, n, 0, 'A');
            for (Map<String, Integer> map : list) {
                map.forEach((key, value) -> {
                    if (value == max) {
                        result.add(key);
                    }
                });
            }
        }
        Collections.sort(result);
        return result.toArray(new String[result.size()]);
    }

    private static void DFS(String[] orders, int n, int count, char c) {
        if (count == n) {
            int cnt = 0;
            for (String order : orders) {
                boolean ch = true;
                for (char c1 : check) {
                    if (!order.contains(String.valueOf(c1))) {
                        ch = false;
                        break;
                    }
                }
                if (ch) {
                    cnt++;
                }
            }
            if (cnt >= 2) {
                max = Math.max(cnt, max);
                Map<String, Integer> map = new HashMap<>();
                map.put(String.valueOf(check), cnt);
                list.add(map);
            }
            return;
        }

        for (int i = c; i <= 'Z'; i++) {
            if (chars[i - 65] == 0) {
                chars[i - 65] = 1;
                check[count] = (char) i;
                DFS(orders, n, count + 1, (char) i);
                chars[i - 65] = 0;
            }
        }
    }
}
