package programmers.problem.level2.level2_1;

import java.util.Stack;

public class Solution4 {
    boolean solution(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        if (chars[0] == ')') return false;
        stack.add(chars[0]);
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.add('(');
            } else {
                if (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
