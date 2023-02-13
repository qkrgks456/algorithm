package programmers.problem.level1.level1_9;

import java.util.HashMap;
import java.util.Map;

public class Solution5 {

    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 'a'; i <= 'z'; i++) {
            map.put(String.valueOf((char) i), -1);
        }
        String[] strings = s.split("");
        int[] result = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            if (map.get(strings[i]) == -1) {
                result[i] = -1;
                map.put(strings[i], i);
                continue;
            }
            result[i] = i - map.get(strings[i]);
            map.put(strings[i], i);
        }
        return result;
    }

}
