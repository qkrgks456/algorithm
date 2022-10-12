package programmers.problem.level2.level2_2;

import java.util.Stack;

public class Solution3 {

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        if (chars.length == 1) return 0;
        stack.add(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (!stack.isEmpty()) {
                char c = stack.peek();
                if (c == chars[i]) {
                    stack.pop();
                } else {
                    stack.add(chars[i]);
                }
            } else {
                stack.add(chars[i]);
            }
        }
        if (!stack.isEmpty()) {
            return 0;
        }
        return 1;
    }

}
