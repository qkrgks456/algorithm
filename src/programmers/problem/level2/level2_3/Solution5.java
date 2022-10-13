package programmers.problem.level2.level2_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution5 {
    public static int solution(String s) {
        String[] strings = s.split("");
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < strings.length; i++) {
            queue.add(strings[i]);
        }
        int result = 0;
        for (int i = 0; i < strings.length; i++) {
            if (check(queue.toArray(new String[queue.size()]))) {
                result++;
            }
            queue.add(queue.poll());
        }
        return result;
    }

    public static void main(String[] args) {
        solution("[](){}");
    }

    public static boolean check(String[] strings) {
        Stack<String> stack = new Stack<>();
        String c = strings[0];
        switch (c) {
            case ")":
            case "}":
            case "]":
                return false;
            default:
                stack.add(c);
        }
        for (int i = 1; i < strings.length; i++) {
            String first = strings[i];
            if (!stack.isEmpty()) {
                String second = stack.peek();
                switch (second) {
                    case "(":
                        if (first.equals(")")) {
                            stack.pop();
                        } else {
                            stack.add(first);
                        }
                        break;
                    case "{":
                        if (first.equals("}")) {
                            stack.pop();
                        } else {
                            stack.add(first);
                        }
                        break;
                    case "[":
                        if (first.equals("]")) {
                            stack.pop();
                        } else {
                            stack.add(first);
                        }
                        break;
                }
            } else {
                stack.add(first);
            }
        }
        if (stack.isEmpty()) {
            return true;
        }
        return false;
    }
}
