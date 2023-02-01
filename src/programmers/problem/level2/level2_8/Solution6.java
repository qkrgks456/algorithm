package programmers.problem.level2.level2_8;

public class Solution6 {
    static int[][] list;
    static int[] check;
    static int count;

    public int solution(int n, int[][] wires) {

        list = new int[n + 1][n + 1];
        check = new int[n + 1];
        for (int i = 0; i < wires.length; i++) {
            list[wires[i][0]][wires[i][1]] = 1;
            list[wires[i][1]][wires[i][0]] = 1;
        }

        int result = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (list[i][j] == 1) {
                    list[i][j] = 0;
                    list[j][i] = 0;
                    check[i] = 1;
                    count = 0;
                    DFS(i);
                    result = Math.min(result, Math.abs(n - count - count));
                    list[i][j] = 1;
                    list[j][i] = 1;
                    check[i] = 0;
                }
            }
        }
        return result;
    }


    public void DFS(int n) {
        count++;
        for (int i = 1; i < list.length; i++) {
            if (list[n][i] == 1 && check[i] == 0) {
                check[i] = 1;
                DFS(i);
                check[i] = 0;
            }
        }
    }
}
