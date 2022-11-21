package programmers.problem.level2.level2_7;

public class Solution1 {
    static int[][] check;
    static int[] result = new int[2];

    public int[] solution(int[][] arr) {
        check = arr.clone();
        DFS(0, 0, arr.length);
        return result;
    }

    public void DFS(int x, int y, int n) {
        int num = check[x][y];
        // 분할정복
        if (n == 1) {
            result[num]++;
            return;
        }
        boolean ch = true;
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (num != check[i][j]) {
                    ch = false;
                }
            }
        }
        // 만약 다 동일하면 더 세지마
        if (ch) {
            result[num]++;
            return;
        }

        int size = n / 2;
        DFS(x, y, size); // 2사분면
        DFS(x, y + size, size); // 3사분면
        DFS(x + size, y, size); // 1사분면
        DFS(x + size, y + size, size); // 4사분면
    }
}
