package programmers.kakao;

import java.util.ArrayList;
import java.util.List;

public class Solution5 {
    static int[][][] ch;
    static List<List<Integer>> list = new ArrayList<>();
    static int[] infos;
    static int result = Integer.MIN_VALUE;

    public int solution(int[] info, int[][] edges) {
        ch = new int[info.length][info.length + 1][info.length + 1];
        infos = info;
        for (int i = 0; i < info.length; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            list.get(edges[i][0]).add(edges[i][1]);
            list.get(edges[i][1]).add(edges[i][0]);
        }
        DFS(0, 0, 0);
        return result;
    }

    private void DFS(int num, int sheep, int wolf) {

        if (infos[num] == 0) {
            sheep++;
        } else if (infos[num] == 1) {
            wolf++;
        }

        if (sheep <= wolf) {
            return;
        }
        result = Math.max(result, sheep);
        for (int n : list.get(num)) {
            int check = infos[num];
            if (ch[n][sheep][wolf] == 0) {
                ch[num][sheep][wolf] = 1;
                infos[num] = -1;
                DFS(n, sheep, wolf);
                infos[num] = check;
                ch[num][sheep][wolf] = 0;
            }
        }
    }
}
