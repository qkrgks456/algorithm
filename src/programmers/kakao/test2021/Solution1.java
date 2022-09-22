package programmers.kakao.test2021;

import java.util.Locale;

public class Solution1 {
    public String solution(String new_id) {
        String answer = "";
        answer = new_id.toLowerCase(Locale.ROOT);
        String exp = "[^\\w-\\.]";
        answer = answer.replaceAll(exp, "");
        exp = "\\.{2,}";
        answer = answer.replaceAll(exp, ".");
        exp = "^\\.|\\.$";
        answer = answer.replaceAll(exp, "");
        if (answer.isEmpty()) {
            answer += "a";
        }
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            exp = "\\.$";
            answer = answer.replaceAll(exp, "");
        }
        if (answer.length() <= 2) {
            String last = answer.substring(answer.length() - 1);
            while (answer.length() != 3) {
                answer += last;
            }
        }
        return answer;
    }
}
