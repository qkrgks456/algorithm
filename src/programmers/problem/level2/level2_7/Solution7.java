package programmers.problem.level2.level2_7;

import java.util.*;

public class Solution7 {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : tangerine) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        List<Integer> valueList = new ArrayList<>(map.values());
        valueList.sort(Comparator.reverseOrder());
        int sum = 0;
        for (int i = 0; i < valueList.size(); i++) {
            sum += valueList.get(i);
            if (sum >= k) return i + 1;
        }
        return 0;
    }
}
