package programmers.problem.level1.level1_7;

import java.util.ArrayList;
import java.util.List;

public class Solution6 {
    public int[] solution(long n) {
        List<Integer> list = new ArrayList<>();
        for (char c : new StringBuilder(String.valueOf(n)).reverse().toString().toCharArray()) {
            list.add(c - '0');
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
