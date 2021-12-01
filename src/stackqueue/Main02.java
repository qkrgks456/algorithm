package stackqueue;

import java.util.Scanner;
import java.util.Stack;

public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] chars = str.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            stack.push(chars[i]);
            if (chars[i] == ')') {
                while (stack.pop() != '(') ;
            }
        }
        for (char c : stack) {
            System.out.print(c);
        }
    }
}
