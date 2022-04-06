package baekjoon.etc2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main6593 {
    static ThreePoint arrive;
    static int L, R, C;
    static char[][][] chars;
    static int[][][] ch, result;
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            L = Integer.parseInt(stringTokenizer.nextToken());
            R = Integer.parseInt(stringTokenizer.nextToken());
            C = Integer.parseInt(stringTokenizer.nextToken());
            if (L == 0 && R == 0 && C == 0) {
                break;
            }
            chars = new char[L][R][C];
            ch = new int[L][R][C];
            result = new int[L][R][C];
            Queue<ThreePoint> queue = new LinkedList<>();
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String s = bufferedReader.readLine();
                    for (int k = 0; k < C; k++) {
                        chars[i][j][k] = s.charAt(k);
                        if (chars[i][j][k] == 'S') {
                            ch[i][j][k] = 1;
                            queue.add(new ThreePoint(i, j, k));
                        } else if (chars[i][j][k] == 'E') {
                            arrive = new ThreePoint(i, j, k);
                        }
                    }
                }
                bufferedReader.readLine();
            }
            BFS(queue);
        }
    }

    public static void BFS(Queue<ThreePoint> queue) {
        while (!queue.isEmpty()) {
            ThreePoint point = queue.poll();


        }
    }
}

class ThreePoint {
    public int z;
    public int x;
    public int y;

    public ThreePoint(int z, int x, int y) {
        this.z = z;
        this.x = x;
        this.y = y;
    }
}


