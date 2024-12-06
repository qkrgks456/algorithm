package baekjoon.v1.step.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main06 {
    // 스도쿠 못하겠다 재귀 쥿까! 왜 이렇게 어렵니 도대체
    static int[][] ints;

    public static void main(String[] args) throws Exception {
        ints = new int[9][9];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String s = bufferedReader.readLine();
            String[] strings = s.split(" ");
            for (int j = 0; j < 9; j++) {
                ints[i][j] = Integer.parseInt(strings[j]);
            }
        }
        recursion(0, 0);
    }

    public static void recursion(int row, int col) {
        if (col == 9) {
            recursion(row + 1, 0);
            return;
        }
        if (row == 9) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    stringBuilder.append(ints[i][j] + " ");
                }
                stringBuilder.append("\n");
            }
            System.out.println(stringBuilder);
            // 시스템 종료 시키는 것도 절대 생각 못하고
            System.exit(0);
        }
        if (ints[row][col] == 0) {
            for (int i = 1; i <= 9; i++) {
                if (check(i, row, col)) {
                    ints[row][col] = i;
                    recursion(row, col + 1);
                }
            }
            // 0으로 풀어줘야 하는것도 절대 생각 못했고
            ints[row][col] = 0;
            return;
        }
        // 여기 호출도 절대 생각 못했고
        recursion(row, col + 1);
    }


    // 이거 체크하는것까지는 구현 할 수 있다
    public static boolean check(int num, int row, int col) {
        // 행에 있는지
        for (int i = 0; i < 9; i++) {
            if (ints[i][col] == num) {
                return false;
            }
        }
        // 열에 있는지
        for (int i = 0; i < 9; i++) {
            if (ints[row][i] == num) {
                return false;
            }
        }

        // 아홉칸 짜리에 있는지 시작점 구해서 3만 더해주면 된다
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (ints[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}
