package baekjoon.step.stack;

import java.util.Scanner;
import java.util.Stack;

public class Main05 {
    public static void main(String[] args) {
        // 아니 이게 왜 자꾸 쉽다는거야 개 어려운데
        // 진짜 납득이 안가네; 에반디 이건 강의 봐야됨
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        StringBuilder stringBuilder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int count = 0;
        while (n-- > 0) {
            int val = scanner.nextInt();
            if (val > count) {
                for (int j = count + 1; j <= val; j++) {
                    stack.push(j);
                    stringBuilder.append("+").append("\n");
                }
                count = val;
            } else if (stack.peek() != val) {
                System.out.println("NO");
                return;
            }
            stack.pop();
            stringBuilder.append("-").append("\n");
        }
        System.out.println(stringBuilder);
    }
}
