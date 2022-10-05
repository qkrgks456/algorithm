package programmers.problem.level1.level1_4;

import java.util.Locale;

public class Solution7 {
    public static String solution(String s) {
        int num = 0;
        String[] strings = s.split("");
        for (int i = 0; i < strings.length; i++) {
            if (strings[i].equals(" ")) {
                num = 0;
                continue;
            }
            if (num % 2 == 0) {
                strings[i] = strings[i].toUpperCase(Locale.ROOT);
            } else {
                strings[i] = strings[i].toLowerCase(Locale.ROOT);
            }
            num++;
        }
        return String.join("", strings);
    }

}
