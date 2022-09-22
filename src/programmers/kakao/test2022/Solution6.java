package programmers.kakao.test2022;

public class Solution6 {
    // 이거 누적합 풀이는 어떻게 생각하내냐
    // 양끝에 마이너스 해주고 빼기일때는 양끝에 플러스 해주고
    // 행 누적합
    // 열 누적합
    // 해서 결과 배열
    public int solution(int[][] board, int[][] skill) {
        int[][] check = new int[board.length + 1][board[0].length + 1];
        // 일단 끝 모서리들 값 구해주기
        for (int[] ints : skill) {
            int type = ints[0];
            if (type == 1) {
                check[ints[1]][ints[2]] -= ints[5];
                check[ints[3] + 1][ints[4] + 1] -= ints[5];
                check[ints[3] + 1][ints[2]] += ints[5];
                check[ints[1]][ints[4] + 1] += ints[5];
            } else {
                check[ints[1]][ints[2]] += ints[5];
                check[ints[3] + 1][ints[4] + 1] += ints[5];
                check[ints[3] + 1][ints[2]] -= ints[5];
                check[ints[1]][ints[4] + 1] -= ints[5];
            }
        }

        // 행 누적합
        for (int i = 0; i < check.length; i++) {
            for (int j = 0; j < check[0].length - 1; j++) {
                check[i][j + 1] += check[i][j];
            }
        }
        // 열 누적합
        for (int i = 0; i < check[0].length; i++) {
            for (int j = 0; j < check.length - 1; j++) {
                check[j + 1][i] += check[j][i];
            }
        }
        int result = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] += check[i][j];
                if (board[i][j] > 0) result++;
            }
        }
        return result;
    }
}
