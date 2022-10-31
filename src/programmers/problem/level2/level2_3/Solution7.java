package programmers.problem.level2.level2_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution7 {
    static Map<String, List<String>> map = new HashMap<>();

    public int solution(String[][] clothes) {
        for (int i = 0; i < clothes.length; i++) {
            if (map.containsKey(clothes[i][1])) {
                map.get(clothes[i][1]).add(clothes[i][0]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(clothes[i][0]);
                map.put(clothes[i][1], list);
            }
        }
        int result = 1;

        for (String s : map.keySet()) {
            result *= 1 + map.get(s).size();
        }
        return result - 1;
    }

}
