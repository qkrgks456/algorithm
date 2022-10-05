package programmers.problem.level1.level1_1;

public class Solution2 {

    public int solution(int n) {
        int answer = 0;
        for (int i = 2; i <= 1000000; i++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
