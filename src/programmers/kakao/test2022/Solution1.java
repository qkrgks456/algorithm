package programmers.kakao.test2022;

import java.util.*;

public class Solution1 {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (String s : id_list) {
            map.put(s, new HashSet<>());
            map2.put(s, 0);
        }

        for (String s : report) {
            StringTokenizer stringTokenizer = new StringTokenizer(s);
            String id = stringTokenizer.nextToken();
            String reportId = stringTokenizer.nextToken();
            Set<String> set = map.get(id);
            map.put(id, set);
            if (!set.contains(reportId)) {
                int n = map2.get(reportId);
                map2.put(reportId, ++n);
            }
            set.add(reportId);
        }
        answer = new int[id_list.length];
        for (String s : map2.keySet()) {
            if (map2.get(s) >= k) {
                for (int i = 0; i < id_list.length; i++) {
                    if (map.get(id_list[i]).contains(s)) {
                        answer[i]++;
                    }
                }
            }
        }
        return answer;
    }
}
