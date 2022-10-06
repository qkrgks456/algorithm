package programmers.problem.level2.level2_1;

import java.util.Arrays;

public class Solution1 {
    public String solution(String s) {
        int[] ints = Arrays.stream(s.split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();
        return ints[0] + " " + ints[ints.length - 1];
    }
}
