package programmers.problem.level1.level1_8;

public class Solution1 {
    public int solution(int n) {
        String.valueOf(n);
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
