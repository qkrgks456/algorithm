package baekjoon.v2.Implementation;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main20125 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] map = new char[n][n];
        for (int i = 0; i < n; i++) {
            char[] charArray = br.readLine().toCharArray();
            System.arraycopy(charArray, 0, map[i], 0, n);
        }

        Point heart = getHeart(n, map);
        StringBuilder sb = new StringBuilder();
        sb.append(heart.x + 1).append(" ").append(heart.y + 1).append("\n");
        // 왼팔
        int count = 0;
        int idx = heart.y;
        while (true) {
            if (idx - 1 < 0) break;
            if (map[heart.x][idx - 1] == '*') {
                count++;
                idx--;
            } else {
                break;
            }
        }
        sb.append(count).append(" ");
        // 오른팔
        count = 0;
        idx = heart.y;
        while (true) {
            if (idx + 1 >= n) break;
            if (map[heart.x][idx + 1] == '*') {
                count++;
                idx++;
            } else {
                break;
            }
        }
        sb.append(count).append(" ");
        // 허리
        count = 0;
        idx = heart.x;
        while (true) {
            if (idx + 1 == n) break;
            if (map[idx + 1][heart.y] == '*') {
                count++;
                idx++;
            } else {
                break;
            }
        }
        sb.append(count).append(" ");
        int waistX = idx;
        // 왼쪽 다리
        count = 0;
        idx = waistX + 1;
        while (true) {
            if (idx >= n) break;
            if (map[idx][heart.y - 1] == '*') {
                count++;
                idx++;
            } else {
                break;
            }
        }
        sb.append(count).append(" ");
        // 오른쪽 다리
        count = 0;
        idx = waistX + 1;
        while (true) {
            if (idx >= n) break;
            if (map[idx][heart.y + 1] == '*') {
                count++;
                idx++;
            } else {
                break;
            }
        }
        sb.append(count);
        System.out.println(sb);
    }

    private static Point getHeart(int n, char[][] map) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        // 심장 위치 찾기
        Point start = new Point();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == '*') {
                    int count = 0;
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (x >= 0 && y >= 0 && x < n && y < n && map[x][y] == '*') count++;
                    }
                    if (count == 4) return new Point(i, j);
                }
            }
        }
        return start;
    }
}
