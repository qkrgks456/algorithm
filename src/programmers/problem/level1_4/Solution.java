package programmers.problem.level1_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    static int[] result = new int[2];
    static int[] check = new int[201];
    static List<Integer> list = new ArrayList<>();

    public int[] solution(int[] numbers) {
        DFS(0, 2, numbers, 0);
        Collections.sort(list);
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void DFS(int level, int n, int[] numbers, int start) {
        if (level == n) {
            int sum = Arrays.stream(result).sum();
            if (check[sum] == 1) return;
            check[sum] = 1;
            list.add(sum);
            return;
        }
        for (int i = start; i < numbers.length; i++) {
            result[level] = numbers[i];
            DFS(level + 1, n, numbers, i + 1);
        }

    }
}
