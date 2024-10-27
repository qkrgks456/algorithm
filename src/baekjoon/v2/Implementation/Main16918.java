package baekjoon.v2.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16918 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int r = Integer.parseInt(stringTokenizer.nextToken());
        int c = Integer.parseInt(stringTokenizer.nextToken());
        int n = Integer.parseInt(stringTokenizer.nextToken());

        char[][] initial = new char[r][c];
        for (int i = 0; i < r; i++) {
            initial[i] = bufferedReader.readLine().toCharArray();
        }

        if (n == 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    sb.append(initial[i][j]);
                }
                sb.append("\n");
            }
            System.out.print(sb);

        } else if (n % 2 == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < c; j++) {
                    sb.append('O');
                }
                sb.append("\n");
            }
            System.out.print(sb);
        } else {
            char[][] firstExplosion = explode(initial, r, c);
            char[][] secondExplosion = explode(firstExplosion, r, c);

            if (n % 4 == 3) {
                printBoard(firstExplosion, r, c);
            } else if(n % 4 == 1){
                printBoard(secondExplosion, r, c);
            }
        }
    }

    private static char[][] explode(char[][] board, int r, int c) {
        char[][] newBoard = new char[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newBoard[i][j] = 'O';
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 'O') {
                    newBoard[i][j] = '.';
                    for (int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        if (ni >= 0 && nj >= 0 && ni < r && nj < c) {
                            newBoard[ni][nj] = '.';
                        }
                    }
                }
            }
        }
        return newBoard;
    }


    private static void printBoard(char[][] board, int r, int c) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}
