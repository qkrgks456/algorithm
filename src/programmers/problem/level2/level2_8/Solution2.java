package programmers.problem.level2.level2_8;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Long> q1 = new LinkedList<>();
        Queue<Long> q2 = new LinkedList<>();
        for (int i = 0; i < queue1.length; i++) {
            q1.add((long) queue1[i]);
            q2.add((long) queue2[i]);
        }
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();

        int count = 0;
        while (true) {
            if (count > (queue1.length + queue2.length) * 2) return -1;
            if (sum1 > sum2) {
                count++;
                Long n1 = q1.poll();
                sum1 -= n1;
                sum2 += n1;
                q2.add(n1);
            } else if (sum2 > sum1) {
                count++;
                Long n2 = q2.poll();
                sum1 += n2;
                sum2 -= n2;
                q1.add(n2);
            } else {
                return count;
            }
        }
    }
}
