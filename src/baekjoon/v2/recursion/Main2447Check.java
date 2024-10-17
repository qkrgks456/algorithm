package baekjoon.v2.recursion;

import java.util.Scanner;

public class Main2447Check {
    static char[][] chars;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        chars = new char[n][n];
        DFS(0, 0, n, 0);

        // 출력
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                stringBuilder.append(chars[i][j]);
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
    }

    public static void DFS(int x, int y, int n, int blank) {
        // 5번째 공백확인 되었으면 공백추가
        if (blank == 1) {
            for (int i = x; i < x + n; i++) {
                for (int j = y; j < y + n; j++) {
                    chars[i][j] = ' ';
                }
            }
            return;
        }
        // 재귀완료시 * 추가
        if (n == 1) {
            chars[x][y] = '*';
            return;
        }
        // 4번하고 5번째에 공백을 남기는 규칙이 있음 근데 여기가 개같이 어렵다
        int size = n / 3;
        int count = 0;
        for (int i = x; i < x + n; i += size) {
            for (int j = y; j < y + n; j += size) {
                count++;
                if (count == 5) {
                    DFS(i, j, size, 1);
                } else {
                    DFS(i, j, size, 0);
                }
            }
        }


    }
}
