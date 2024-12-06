package baekjoon.v1.etc4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main9935 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String s2 = bufferedReader.readLine();
        char[] chars = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            stack.add(chars[i]);
            if (stack.size() >= s2.length()) {
                boolean check = true;
                for (int j = 0; j < s2.length(); j++) {
                    if (stack.get(stack.size() - s2.length() + j) != s2.charAt(j)) {
                        check = false;
                        break;
                    }
                }
                if (check) {
                    for (int j = 0; j < s2.length(); j++) {
                        stack.pop();
                    }
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (stack.size() == 0) {
            System.out.println("FRULA");
        } else {
            while (!stack.isEmpty()) {
                stringBuilder.append(stack.pop());
            }
            System.out.println(stringBuilder.reverse());
        }
    }
}
