package programmers.problem.level2.level2_4;

import java.util.*;

public class Solution1 {
    public static int solution(String str1, String str2) {
        str1 = str1.toLowerCase(Locale.ROOT);
        str2 = str2.toLowerCase(Locale.ROOT);

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        Set<String> set = new HashSet<>();

        for (int i = 0; i < str1.length() - 1; i++) {
            String s = str1.substring(i, i + 2);
            if (Character.isAlphabetic(s.charAt(0)) && Character.isAlphabetic(s.charAt(1))) {
                map1.put(s, map1.getOrDefault(s, 0) + 1);
                set.add(s);
            }
        }

        for (int i = 0; i < str2.length() - 1; i++) {
            String s = str2.substring(i, i + 2);
            if (Character.isAlphabetic(s.charAt(0)) && Character.isAlphabetic(s.charAt(1))) {
                map2.put(s, map2.getOrDefault(s, 0) + 1);
                set.add(s);
            }
        }

        int total = 0;
        for (String s : set) { // 합집합 까지는 이해가 감
            total += Math.max(map1.getOrDefault(s, 0), map2.getOrDefault(s, 0));
        }
        int answer = 0;
        for (String s : map2.keySet()) {
            if (map1.containsKey(s)) {
                answer += Math.min(map1.get(s), map2.get(s));
            }
        }

        if (total == 0) return 65536;
        return answer * 65536 / total;
    }


}
