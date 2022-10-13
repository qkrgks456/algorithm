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
            result++;
            int size = queue.size();
            for (int i = 0; i < size; i += 2) {
                int first = queue.poll();
                int second = queue.poll();
                if ((first == a && second == b) || (first == b && second == a)) {
                    return result;
                } else if (first != a && first != b && second != a && second != b) {
                    queue.add(first);
                } else if (first == a || first == b) {
                    queue.add(first);
                } else if (second == a || second == b) {
                    queue.add(second);
                }
            }
        }
        return result;
    }
}
