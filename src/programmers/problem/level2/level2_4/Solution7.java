package programmers.problem.level2.level2_4;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution7 {
    public int[] solution(int[] prices) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int price : prices) {
            queue.add(price);
        }
        while (!queue.isEmpty()) {
            int check = queue.poll();
            int count = 0;
            for (int n : queue) {
                count++;
                if (n < check) break;
            }
            res.add(count);
        }
        return res.stream().mapToInt(i -> i).toArray();
    }
}
