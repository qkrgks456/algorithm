package programmers.problem.level2.level2_8;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {

    public int[] solution(int n, long k) {
        int[] result = new int[n];
        List<Integer> list = new ArrayList<>();
        long fa = 1;

        for (int i = 1; i <= n; i++) {
            fa *= i;
            list.add(i);
        }
        k--; // 여기 이해 안됨
        int i = 0;
        while (n > 0) {
            fa /= n;
            int val = (int) (k / fa);
            result[i] = list.get(val);
            list.remove(val);
            k %= fa;
            i++;
            n--;
        }
        return result;
    }

}
