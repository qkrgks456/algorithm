package programmers.problem.level2.level2_9;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {
    static List<int[]> list = new ArrayList<>();

    public int[][] solution(int n) {
        DFS(n, 1, 2, 3);
        int[][] answer = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            answer[i][0] = list.get(i)[0];
            answer[i][1] = list.get(i)[1];
        }
        return answer;
    }

    public void DFS(int n, int start, int mid, int to) {
        if (n == 1) {
            list.add(new int[]{start, to});
            return;
        }
        DFS(n - 1, start, to, mid);
        list.add(new int[]{start, to});
        DFS(n - 1, mid, start, to);
    }
}
