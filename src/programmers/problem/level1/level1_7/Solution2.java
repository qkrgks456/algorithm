package programmers.problem.level1.level1_7;

import java.util.Arrays;
import java.util.stream.Stream;

public class Solution2 {
    public long solution(long n) {
        int[] arrNum = Stream.of(String.valueOf(n).split("")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arrNum);
        return Long.valueOf(new StringBuilder(Arrays.toString(arrNum).replaceAll("[^0-9]", "")).reverse().toString());
    }
}
