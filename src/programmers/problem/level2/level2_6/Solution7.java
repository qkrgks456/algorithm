package programmers.problem.level2.level2_6;

import java.util.HashMap;
import java.util.Map;

public class Solution7 {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }

        int left = 0;
        int right = 9;
        int result = 0;
        while (right != discount.length) {
            Map<String, Integer> check = new HashMap<>();
            for (int i = left; i <= right; i++) {
                check.put(discount[i], check.getOrDefault(discount[i], 0) + 1);
            }
            if (map.equals(check)) result++;
            left++;
            right++;
        }
        return result;
    }
}
