package programmers.problem.level2.level2_9;

import java.util.Stack;

public class Solution1 {

    public int solution(int[] order) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        int n = 0;
        for (int i = 1; i <= order.length; i++) {
            if (order[n] != i) {
                stack.add(i);
                continue;
            }

            n++;
            result++;
            while (!stack.isEmpty() && stack.peek() == order[n]) {
                stack.pop();
                n++;
                result++;
            }
        }
        return result;
    }
}
