package programmers.problem.level2.level2_8;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution4 {
    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        set.add(topping[0]);
        for (int i = 1; i < topping.length; i++) {
            map.put(topping[i], map.getOrDefault(topping[i], 0) + 1);
        }
        if (set.size() == map.size()) answer++;
        for (int i = 1; i < topping.length; i++) {
            set.add(topping[i]);
            map.put(topping[i], map.get(topping[i]) - 1);
            if (map.get(topping[i]) == 0) map.remove(topping[i]);
            if (set.size() == map.size()) answer++;
        }
        return answer;
    }

}
