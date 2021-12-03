package inflearn.stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class Main04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] chars = str.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int num1 = 0;
        int num2 = 0;
        for (char c : chars) {
            if (c == '*') {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 * num1);
            } else if (c == '+') {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 + num1);
            } else if (c == '-') {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 - num1);
            } else if (c == '/') {
                num1 = stack.pop();
                num2 = stack.pop();
                stack.push(num2 / num1);
            } else {
                stack.push(Integer.parseInt(String.valueOf(c)));
            }
        }
        System.out.println(stack.pop());
    }
}
