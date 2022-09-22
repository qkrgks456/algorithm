package programmers.kakao.test2021;

import java.util.*;

public class Solution3 {
    static Map<String, List<Integer>> map = new HashMap<>();

    public static int[] solution(String[] info, String[] query) {
        int[] result = new int[query.length];
        for (String s : info) {
            String[] strings = s.split(" ");
            DFS(strings, 0, "");
        }
        // 정렬
        map.forEach((key, value) -> Collections.sort(value));

        // 이분탐색
        for (int i = 0; i < query.length; i++) {
            query[i] = query[i].replaceAll(" and ", "");
            String[] strings = query[i].split(" ");
            int score = Integer.parseInt(strings[1]);
            if (map.containsKey(strings[0])) {
                List<Integer> list = map.get(strings[0]);
                int left = 0;
                int right = list.size() - 1;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (list.get(mid) < score) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                result[i] = list.size() - left;
            }
        }

        return result;
    }


    public static void DFS(String[] strings, int n, String str) {
        if (n == 4) {
            if (!map.containsKey(str)) {
                List<Integer> list = new ArrayList<>();
                list.add(Integer.parseInt(strings[4]));
                map.put(str, list);
            } else {
                map.get(str).add(Integer.parseInt(strings[4]));
            }
            return;
        }
        DFS(strings, n + 1, str + "-");
        DFS(strings, n + 1, str + strings[n]);
    }
}