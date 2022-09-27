package programmers.problem.level1_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution5 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (String s : completion) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }
        for (String s : participant) {
            if (!map.containsKey(s)) {
                answer = s;
                break;
            }
            int num = map.get(s);
            if (num == 0) {
                answer = s;
            } else {
                num--;
                map.put(s, num);
            }
        }
        return answer;
    }
}
