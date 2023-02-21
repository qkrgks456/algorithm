package programmers.problem.level1.level1_10;

import java.util.Stack;

public class Solution2 {

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Stack<String> stack1 = new Stack<>();
        for (int i = cards1.length - 1; i >= 0; i--) {
            stack1.add(cards1[i]);
        }
        Stack<String> stack2 = new Stack<>();
        for (int i = cards2.length - 1; i >= 0; i--) {
            stack2.add(cards2[i]);
        }

        for (int i = 0; i < goal.length; i++) {
            String ch1 = "", ch2 = "";
            if (!stack1.isEmpty()) ch1 = stack1.peek();
            if (!stack2.isEmpty()) ch2 = stack2.peek();
            if (ch1.equals(goal[i])) stack1.pop();
            if (ch2.equals(goal[i])) stack2.pop();
            if (!ch1.equals(goal[i]) && !ch2.equals(goal[i])) return "No";
        }
        return "Yes";
    }

}
