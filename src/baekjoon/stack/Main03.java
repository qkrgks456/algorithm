package baekjoon.stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main03 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            Stack<String> stack = new Stack<>();
            String s = bufferedReader.readLine();
            String[] strings = s.split("");
            for (String s1 : strings) {
                if (s1.equals(")")) {
                    if (!stack.empty() && stack.contains("(")) {
                        stack.pop();
                    } else {
                        stack.add(s1);
                    }
                } else {
                    stack.add(s1);
                }
            }
            if (stack.empty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
