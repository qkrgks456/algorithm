package programmers.problem.level2.level2_10;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {

    public int solution(String name) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (char i = 'A'; i <= 'Z'; i++) {
            map.put(String.valueOf(i), count);
            if (i <= 'M') {
                count++;
                continue;
            }
            count--;
        }
        String[] strings = name.split("");
        int result = 0;
        boolean aCheck = true;
        for (int i = 0; i < strings.length; i++) {
            if (!strings[i].equals("A")) aCheck = false;
            result += map.get(strings[i]);
        }
        if (aCheck) return 0;
        



        int answer = 0;
        return answer;
    }

}

