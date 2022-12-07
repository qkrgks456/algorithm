package programmers.problem.level2.level2_7;

import java.util.Stack;

public class Solution5 {
    static StringBuilder result = new StringBuilder();

    public String solution(String p) {
        if (stringCheck(p)) return p;
        DFS(p);

        return result.toString();
    }

    public void DFS(String s) {
        if (s.equals("")) return;
        String[] strings = separation(s);
        String u = strings[0];
        String v = strings[1];
        if (stringCheck(u)) {
            result.append(u);
            DFS(v);
        } else {
            result.append("(");
            DFS(v);
            result.append(")");
            if (!u.equals("")) {
                u = u.substring(1);
                u = u.substring(0, u.length() - 1);
                if (!u.equals("")) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < u.length(); i++) {
                        if (u.charAt(i) == '(') {
                            stringBuilder.append(")");
                        } else {
                            stringBuilder.append("(");
                        }
                    }
                    result.append(stringBuilder);
                }
            }
        }
    }

    public String[] separation(String s) {
        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                String[] strings = new String[2];
                strings[0] = s.substring(0, i + 1);
                strings[1] = s.substring(i + 1);
                return strings;
            }
        }
        return null;
    }

    public boolean stringCheck(String s) {
        Stack<Character> stack = new Stack<>();
        stack.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && stack.peek() == '(' && c == ')') {
                stack.pop();
            } else {
                stack.add(c);
            }
        }
        return stack.isEmpty();
    }
}
