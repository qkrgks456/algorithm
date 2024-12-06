package baekjoon.v1.step.stack;

import java.util.Scanner;
import java.util.Stack;

public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int num = scanner.nextInt();
            if (num == 0) {
                stack.pop();
            } else {
                stack.push(num);
            }
        }
        int result = 0;
        while (!stack.empty()) {
            result += stack.pop();
        }
        System.out.println(result);
    }
}
