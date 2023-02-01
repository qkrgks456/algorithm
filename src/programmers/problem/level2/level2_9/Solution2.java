package programmers.problem.level2.level2_9;

public class Solution2 {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        if (s.length() == 1) return 1;
        for (int i = 1; i <= s.length() / 2; i++) {
            String ch = s.substring(0, i);
            StringBuilder result = new StringBuilder();
            int count = 1;
            for (int j = i; j < s.length(); j += i) {
                if (j + i > s.length()) {
                    result.append(s.substring(j));
                    break;
                }
                String substring = s.substring(j, j + i);
                if (ch.equals(substring)) {
                    count++;
                    continue;
                }
                if (count != 1) {
                    result.append(count).append(ch);
                } else {
                    result.append(ch);
                }
                count = 1;
                ch = substring;

            }
            if (count != 1) {
                result.append(count).append(ch);
            } else {
                result.append(ch);
            }
            answer = Math.min(answer, result.length());
        }

        return answer;
    }
}
