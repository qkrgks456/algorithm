package programmers.problem.level1.level1_6;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        for (int num : arr) {
            if (num % divisor == 0) list.add(num);
        }
        if (list.size() == 0) list.add(-1);
        return list.stream().sorted().mapToInt(i -> i).toArray();
    }
}
