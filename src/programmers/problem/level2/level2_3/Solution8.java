package programmers.problem.level2.level2_3;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution8 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        for (int n : progresses) {
            queue.addLast(n);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int n = queue.pollFirst();
                int sum = n + speeds[i];
                queue.addLast(sum);
            }
            int result = 0;
            int num = queue.peekFirst();
            System.out.println(num);
            while (num >= 100) {
                result++;
                queue.pollFirst();
            }
            list.add(result);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
