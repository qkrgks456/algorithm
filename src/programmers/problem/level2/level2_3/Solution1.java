package programmers.problem.level2.level2_3;

public class Solution1 {
    public static int solution(int n) {
        if (n == 1 || n == 2) return 1;
        int result = 1;
        while (n != 1) {
            if (n % 2 != 0) {
                n--;
                result++;
            }
            n /= 2;
        }
        return result;
    }

}
