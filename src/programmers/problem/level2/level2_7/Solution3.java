package programmers.problem.level2.level2_7;

public class Solution3 {
    public static String solution(String number, int k) {
        StringBuilder stringBuilder = new StringBuilder(number);
        for (int i = 0; i < k; i++) {
            int size = stringBuilder.length();
            int idx = size - 1;
            for (int j = 0; j < size - 1; j++) {
                if (stringBuilder.charAt(j) < stringBuilder.charAt(j + 1)) {
                    idx = j;
                    break;
                }
            }
            stringBuilder.deleteCharAt(idx);
        }
        return stringBuilder.toString();
    }

}
