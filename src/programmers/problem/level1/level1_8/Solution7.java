package programmers.problem.level1.level1_8;

public class Solution7 {

    static String[] strings = {"", "aya", "ye", "woo", "ma"};
    static String[] check = {"ayaaya", "yeye", "woowoo", "mama"};

    public static int solution(String[] babbling) {
        int result = 0;
        for (String s : babbling) {
            boolean ch = false;
            for (String value : check) {
                if (s.contains(value)) {
                    ch = true;
                    break;
                }
            }
            if (ch) continue;

            for (int i = 1; i <= 4; i++) {
                s = s.replaceAll(strings[i], String.valueOf(i));
            }
            s = s.replaceAll("[0-9]", "");
            if (s.length() == 0) {
                result++;
            }
        }
        return result;
    }
}
