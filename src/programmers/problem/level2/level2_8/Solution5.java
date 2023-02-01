package programmers.problem.level2.level2_8;

public class Solution5 {

    public int solution(int[][] board) {
        int[][] check = board.clone();
        int result = board[0][0];
        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] == 1) {
                    check[i][j] = Math.min(Math.min(check[i][j - 1], check[i - 1][j]), check[i - 1][j - 1]) + 1;
                    result = Math.max(check[i][j], result);
                }
            }
        }

        return result * result;
    }
}
