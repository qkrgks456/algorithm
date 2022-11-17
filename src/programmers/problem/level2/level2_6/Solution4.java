package programmers.problem.level2.level2_6;

public class Solution4 {
    public int solution(int n) {

        int[] ints = new int[n + 1];
        ints[1] = 1;
        ints[2] = 2;
        for (int i = 3; i <= n; i++) {
            ints[i] = (ints[i - 1] % 1000000007 + ints[i - 2] % 1000000007) % 1000000007;
        }
        return ints[n];
    }
}
