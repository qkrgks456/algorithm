package programmers.problem.level1.level1_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public int solution(int k, int m, int[] score) {
        int result = 0;
        Arrays.sort(score);
        int num = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = score.length - 1; i >= 0; i--, num++) {
            list.add(score[i]);
            if (num == m) {
                result += list.stream()
                        .mapToInt(x -> x)
                        .min()
                        .getAsInt() * m;
                list.clear();
                num = 0;
            }
        }
        return result;
    }
}