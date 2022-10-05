package programmers.problem.level1.level1_6;

public class Solution1 {
    public String solution(String s) {
        char[] chars = s.toCharArray();
        if (chars.length % 2 != 0) {
            return String.valueOf(chars[chars.length / 2]);
        }
        char c1 = chars[(chars.length / 2) - 1];
        char c2 = chars[chars.length / 2];
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c1).append(c2);
        return stringBuilder.toString();
    }
}
