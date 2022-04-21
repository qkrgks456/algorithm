package baekjoon.step.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main04 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            Stack<String> stack = new Stack<>();
            String s = bufferedReader.readLine();
            if (s.equals(".")) {
                break;
            }
            String[] strings = s.split("");
            for (String s1 : strings) {
                if (s1.equals("(") || s1.equals("[")) {
                    stack.push(s1);
                } else if (s1.equals(")")) {
                    if (!stack.empty() && stack.peek().equals("(")) {
                        stack.pop();
                    } else {
                        stack.push(s1);
                    }
                } else if (s1.equals("]")) {
                    if (!stack.empty() && stack.peek().equals("[")) {
                        stack.pop();
                    } else {
                        stack.push(s1);
                    }
                }
            }
            if (stack.empty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
