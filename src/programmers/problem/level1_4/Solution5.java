package programmers.problem.level1_4;

public class Solution5 {
    public String solution(String s, int n) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != ' ') {
                byte b = (byte) chars[i];
                int result = b + n;
                if (b >= 65 && b <= 90) {
                    if (b + n > 90) result -= 26;
                } else {
                    if (b + n > 122) result -= 26;
                }
                chars[i] = (char) result;
            }
        }
        return String.valueOf(chars);
    }
}
