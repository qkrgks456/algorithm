package programmers.problem.level1_5;

public class Solution7 {
    public String solution(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                stringBuilder.append("수");
                continue;
            }
            stringBuilder.append("박");
        }
        return stringBuilder.toString();
    }
}
