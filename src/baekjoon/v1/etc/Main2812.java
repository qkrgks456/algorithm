package baekjoon.v1.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main2812 {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        int N = Integer.parseInt(strings[0]);
        int K = Integer.parseInt(strings[1]);
        String[] strings1 = bufferedReader.readLine().split("");
        char[] chars = new char[strings1.length];
        Stack<Character> stack = new Stack<>();
        stack.push(strings1[0].charAt(0));
        int count = 0;
        for (int i = 1; i < strings1.length; i++) {
            chars[i] = strings1[i].charAt(0);
            while (count < K && !stack.isEmpty() && stack.peek() < chars[i]) {
                stack.pop();
                count++;
            }
            stack.push(chars[i]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N - K; i++) {
            stringBuilder.append(stack.get(i));
        }
        System.out.println(stringBuilder);
    }
}
