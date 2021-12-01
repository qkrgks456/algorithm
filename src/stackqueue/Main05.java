package stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class Main05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                stack.push(chars[i]);
            } else {
                stack.pop();
                if (chars[i - 1] == '(') {
                    result += stack.size();
                } else {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
