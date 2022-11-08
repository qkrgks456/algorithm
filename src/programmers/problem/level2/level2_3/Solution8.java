package programmers.problem.level2.level2_3;

import java.util.*;

public class Solution8 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < progresses.length; i++) {
            int num = (100 - progresses[i]) % speeds[i] != 0 ? (100 - progresses[i]) / speeds[i] + 1 : (100 - progresses[i]) / speeds[i];
            list.add(num);
        }
        int res = 1;
        int count = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (count >= list.get(i)) {
                res++;
            } else {
                result.add(res);
                res = 1;
                count = list.get(i);
            }
        }
        result.add(res);
        return result.stream().mapToInt(i -> i).toArray();
    }
}
