package programmers.problem.level2.level2_6;

import java.util.Arrays;

public class Solution5 {
    public String solution(int[] numbers) {
        String[] strings = new String[numbers.length];
        for (int i = 0; i < strings.length; i++) {
            strings[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strings, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if (strings[0].equals("0")) {
            return "0";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < strings.length; i++) {
            stringBuilder.append(strings[i]);
        }
        return stringBuilder.toString();
    }
}
