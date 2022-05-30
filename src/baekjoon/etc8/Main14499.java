package baekjoon.etc8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main14499 {
    // 1 동 2 서 3 북 4 남
    static int[] dx = {0, 0, 0, -1, 0};
    static int[] dy = {0, 1, -1, 0, 1};
    static int n, m;
    static int[] direction;
    static int[][] ints;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        int x = Integer.parseInt(stringTokenizer.nextToken());
        int y = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        ints = new int[n][m];
        int[][] dice = new int[4][3];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < m; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        direction = new int[k];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < k; i++) {
            direction[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        find(x, y);
    }

    private static void find(int x, int y) {
        Queue<My> queue = new LinkedList<>();
        queue.add(new My(x, y, 1, 1));
        int nx, ny;
        for (int num : direction) {
            My my = queue.poll();
            nx = my.x + dx[num];
            ny = my.y + dy[num];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m) {
                // 하 문제는 주사위인데 저걸 어쩐다 이거 배열 위치 교체 해줘야겠네

            } else {
                queue.add(my);
            }
        }
    }
}

class My {
    int x;
    int y;
    int diceX;
    int diceY;

    public My(int x, int y, int diceX, int diceY) {
        this.x = x;
        this.y = y;
        this.diceX = diceX;
        this.diceY = diceY;
    }
}
