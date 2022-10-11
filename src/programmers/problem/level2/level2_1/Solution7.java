package programmers.problem.level2.level2_1;

public class Solution7 {
    public int solution(int n) {
        int[] ints = new int[n + 1];
        ints[0] = 0;
        ints[1] = 1;
        for (int i = 2; i < ints.length; i++) {
            ints[i] = ((ints[i - 1] % 1234567) + (ints[i - 2] % 1234567)) % 1234567;
        }
        return ints[n];
    }
}
