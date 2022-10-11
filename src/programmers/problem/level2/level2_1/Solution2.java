package programmers.problem.level2.level2_1;

import java.util.Locale;

public class Solution2 {
    public static String solution(String s) {
        String[] strings = s.split("");
        StringBuilder stringBuilder = new StringBuilder();
        boolean check = true;
        String ch;
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].isBlank()) {
                check = true;
                stringBuilder.append(strings[i]);
            } else {
                if (check) {
                    ch = strings[i].toUpperCase(Locale.ROOT);
                    check = false;
                } else {
                    ch = strings[i].toLowerCase(Locale.ROOT);
                }
                stringBuilder.append(ch);
            }
        }
        return stringBuilder.toString();
    }
}