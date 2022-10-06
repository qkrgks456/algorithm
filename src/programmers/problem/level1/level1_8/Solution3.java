package programmers.problem.level1.level1_8;

import java.util.Arrays;

public class Solution3 {
    public double solution(int[] arr) {
        return (double) Arrays.stream(arr).sum() / arr.length;
    }
}
