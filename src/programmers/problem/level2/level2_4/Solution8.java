package programmers.problem.level2.level2_4;

public class Solution8 {
    static int[][] dungeon;
    static int result = 0;
    static int[] check;

    public int solution(int k, int[][] dungeons) {
        dungeon = dungeons.clone();
        check = new int[dungeons.length];
        DFS(k, 0);
        return result;
    }

    public void DFS(int k, int n) {
        result = Math.max(n, result);
        if (n == dungeon.length) {
            return;
        }

        for (int i = 0; i < dungeon.length; i++) {
            if (check[i] == 0) {
                int need = dungeon[i][0];
                int consume = dungeon[i][1];
                if (need <= k) {
                    check[i] = 1;
                    DFS(k - consume, n + 1);
                    check[i] = 0;
                }
            }

        }
    }
}
