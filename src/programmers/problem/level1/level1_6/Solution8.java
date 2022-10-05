package programmers.problem.level1.level1_6;

public class Solution8 {
    public long[] solution(int x, int n) {
        long[] longs = new long[n];
        longs[0] = x;
        for (int i = 1; i < longs.length; i++) {
            longs[i] = longs[i - 1] + x;
        }
        return longs;
    }
}
