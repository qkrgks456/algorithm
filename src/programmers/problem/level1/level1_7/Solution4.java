package programmers.problem.level1.level1_7;

public class Solution4 {
    public boolean solution(int x) {
        int n = x;
        int sum = 0;
        while (n != 0) {
            sum += n % 10;
            n /= 10;
        }
        return x % sum == 0;
    }
}
