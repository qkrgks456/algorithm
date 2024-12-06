package baekjoon.v1.step.stack;

import java.util.Scanner;
import java.util.Stack;

public class Main06 {
    public static void main(String[] args) {
        // 와 인덱스로 넣다뺐다는 예상 못했네 ㅋㅋ
        // 생각보다 이해 할만했다는게 함정 .. 전혀 다른 방식으로 푼 내가 평신이지 ~~
        Stack<Integer> stack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            while (!stack.empty() && ints[stack.peek()] < ints[i]) {
                ints[stack.pop()] = ints[i];
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            ints[stack.pop()] = -1;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int n1 : ints) {
            stringBuilder.append(n1 + " ");
        }
        System.out.println(stringBuilder);
    }
}
