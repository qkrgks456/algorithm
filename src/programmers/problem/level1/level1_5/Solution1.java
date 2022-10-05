package programmers.problem.level1.level1_5;

import java.util.Stack;

public class Solution1 {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            int check = stack.peek();
            if (check != arr[i]) {
                stack.add(arr[i]);
            }
        }
        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
    }
}
