package programmers.problem.level2.level2_2;

import java.util.LinkedList;
import java.util.Queue;

public class Solution6 {
    public int solution(int n, int a, int b) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }
        int result = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();

            }
            result++;
        }

        return result;
    }
}
