package programmers.problem.level2.level2_9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Solution6 {

    static String[][] table;
    static int[] result;
    static List<List<Integer>> ch = new ArrayList<>();

    public int solution(String[][] relation) {
        table = relation.clone();
        for (int i = 1; i <= table[0].length; i++) {
            result = new int[i];
            DFS(i, 0, 0);
        }
        return ch.size();
    }

    public void DFS(int root, int n, int start) {
        if (n == root) {
            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < table.length; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int num : result) {
                    stringBuilder.append(table[i][num]);
                }
                set.add(stringBuilder.toString());
            }
            if (table.length == set.size()) {
                boolean check = true;
                List<Integer> list = Arrays.stream(result)
                        .boxed()
                        .collect(Collectors.toList());
                for (List<Integer> lists : ch) {
                    if (list.containsAll(lists)) {
                        check = false;
                        break;
                    }
                }
                if (check) ch.add(list);
            }
            return;
        }

        for (int i = start; i < table[0].length; i++) {
            result[n] = i;
            DFS(root, n + 1, i + 1);
        }
    }
}
