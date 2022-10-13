package programmers.problem.level2.level2_2;

public class Solution7 {
    public long solution(int n) {
        if (n == 1) return 1;
        long[] longs = new long[n + 1];
        longs[1] = 1;
        longs[2] = 2;
        for (int i = 3; i < longs.length; i++) {
            longs[i] = ((longs[i - 1] % 1234567) + (longs[i - 2] % 1234567)) % 1234567;
        }
        return longs[n];
    }

}
