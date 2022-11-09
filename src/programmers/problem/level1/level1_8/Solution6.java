package programmers.problem.level1.level1_8;

import java.util.Stack;

public class Solution6 {
    public int solution(int[] ingredient) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int n : ingredient) {
            if (stack.size() >= 3) {
                int n1 = stack.pop();
                int n2 = stack.pop();
                int n3 = stack.pop();
                if (n == 1 && n1 == 3 && n2 == 2 && n3 == 1) {
                    result++;
                } else {
                    stack.add(n3);
                    stack.add(n2);
                    stack.add(n1);
                    stack.add(n);
                }
            } else {
                stack.add(n);
            }
        }
        return result;
    }
}
