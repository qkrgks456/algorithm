package programmers.problem.level2.level2_2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution4 {
    public static int solution(int[] people, int limit) {
        Arrays.sort(people);
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < people.length; i++) {
            deque.add(people[i]);
        }
        int result = 0;
        while (!deque.isEmpty()) {
            int first = deque.peekFirst();
            int last = deque.peekLast();
            if (first + last <= limit) {
                deque.pollFirst();
                deque.pollLast();
            } else {
                deque.pollLast();
            }
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        solution(new int[]{30, 40, 50, 60}, 100);
    }
}
