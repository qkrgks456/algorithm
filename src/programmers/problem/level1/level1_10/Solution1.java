package programmers.problem.level1.level1_10;

public class Solution1 {

    public int solution(String s) {
        int result = 0;
        while (s.length() != 0) {
            result++;
            int ch1 = 1;
            int ch2 = 0;
            char ch = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                if (ch == s.charAt(i)) {
                    ch1++;
                } else {
                    ch2++;
                }
                if (ch1 == ch2) {
                    break;
                }
            }
            s = s.substring(ch1 + ch2);
        }
        return result;
    }

}
