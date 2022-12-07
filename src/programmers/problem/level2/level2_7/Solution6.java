package programmers.problem.level2.level2_7;

import java.util.ArrayList;
import java.util.List;

public class Solution6 {
    static String[] strings = {"+", "-", "*"};
    static List<String> cal = new ArrayList<>();
    static List<Long> nums = new ArrayList<>();
    static int[] check = new int[3];
    static long result;

    public long solution(String expression) {
        int numIdx = 0;
        for (int i = 0; i < expression.length(); i++) {
            switch (expression.charAt(i)) {
                case '*':
                case '+':
                case '-':
                    cal.add(String.valueOf(expression.charAt(i)));
                    nums.add(Long.parseLong(expression.substring(numIdx, i)));
                    numIdx = i + 1;
                    break;
            }
        }
        nums.add(Long.parseLong(expression.substring(numIdx)));
        DFS(0, "");
        return result;
    }

    public static void DFS(int n, String s) {
        if (n == 3) {
            // 순서는 정했음 이제 저대로 연산을 어떻게 할지 고민
            result = Math.max(result, Math.abs(calNum(s)));
            return;
        }
        for (int i = 0; i < strings.length; i++) {
            if (check[i] == 0) {
                check[i] = 1;
                DFS(n + 1, s + strings[i]);
                check[i] = 0;
            }
        }
    }

    public static long calNum(String order) {
        List<Long> numsCopy = new ArrayList<>(nums);
        List<String> calCopy = new ArrayList<>(cal);
        String[] orders = order.split("");
        for (String s : orders) {
            for (int i = 0; i < calCopy.size(); i++) {
                if (s.equals(calCopy.get(i))) {
                    long calData;
                    switch (s) {
                        case "+":
                            calData = numsCopy.get(i) + numsCopy.get(i + 1);
                            numsCopy.set(i, calData);
                            numsCopy.remove(i + 1);
                            calCopy.remove(i);
                            i--;
                            break;
                        case "-":
                            calData = numsCopy.get(i) - numsCopy.get(i + 1);
                            numsCopy.set(i, calData);
                            numsCopy.remove(i + 1);
                            calCopy.remove(i);
                            i--;
                            break;
                        case "*":
                            calData = numsCopy.get(i) * numsCopy.get(i + 1);
                            numsCopy.set(i, calData);
                            numsCopy.remove(i + 1);
                            calCopy.remove(i);
                            i--;
                            break;
                    }
                }
            }
        }
        return numsCopy.get(0);
    }
}
