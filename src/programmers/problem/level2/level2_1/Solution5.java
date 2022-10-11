package programmers.problem.level2.level2_1;

public class Solution5 {
    public int[] solution(String s) {
        int result = 0;
        int count = 0;
        while (s.length() != 1) {
            int check = s.length();
            s = s.replaceAll("0", "");
            result += check - s.length();
            s = Integer.toBinaryString(s.length());
            count++;
        }
        int[] answer = {count, result};
        return answer;
    }
}
