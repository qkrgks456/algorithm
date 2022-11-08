package programmers.problem.level2.level2_4;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : phone_book) {
            map.put(s, 1);
        }
        for (String s : phone_book) {
            String[] strings = s.split("");
            String check = "";
            for (String string : strings) {
                check += string;
                if (s.equals(check)) continue;
                if (map.containsKey(check)) {
                    return false;
                }
            }
        }
        return true;
    }
}
