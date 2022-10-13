package programmers.problem.level2.level2_3;

import java.util.*;

public class Solution6 {
    public int[] solution(String s) {
        s = s.replaceAll("\\{", "").replaceAll("\\}", "");
        String[] strings = s.split("\\,");
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            String str = strings[i].trim();
            int n = Integer.parseInt(str);
            if (!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                int count = map.get(n);
                map.put(n, ++count);
            }
        }
        List<Integer> listKeySet = new ArrayList<>(map.keySet());
        Collections.sort(listKeySet, (value1, value2) -> (map.get(value2).compareTo(map.get(value1))));
        return listKeySet.stream().mapToInt(i -> i).toArray();
    }

}
