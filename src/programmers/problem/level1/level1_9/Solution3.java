package programmers.problem.level1.level1_9;

public class Solution3 {
    public int solution(int a, int b, int n) {
        int result = 0;
        while (n / a != 0) {
            int num = (n / a) * b;
            result += num;
            n = n % a + num;
        }
        return result;
    }
}
