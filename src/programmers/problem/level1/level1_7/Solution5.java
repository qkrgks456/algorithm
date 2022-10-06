package programmers.problem.level1.level1_7;

import java.util.Locale;

public class Solution5 {
    boolean solution(String s) {

        String upperCase = s.toUpperCase(Locale.ROOT);
        char[] chars = upperCase.toCharArray();
        int pNum = 0;
        int yNum = 0;
        for (char c : chars) {
            if (c == 'P') pNum++;
            else if (c == 'Y') yNum++;
        }
        return pNum == yNum;
    }
}
