package baekjoon.v1.etc2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main6593 {
    static StringBuilder stringBuilder = new StringBuilder();
    static Queue<ThreePoint> queue;
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
            queue = new LinkedList<>();
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
                        } else if (chars[i][j][k] == '#') {
                            ch[i][j][k] = 1;
                        }
                    }
                }
                bufferedReader.readLine();
            }
            BFS();
        }
        System.out.println(stringBuilder);
    }

    public static void BFS() {
        int nz, nx, ny;
        while (!queue.isEmpty()) {
            ThreePoint point = queue.poll();
            if (point.z == arrive.z && point.x == arrive.x && point.y == arrive.y) {
                stringBuilder.append("Escaped in " + result[point.z][point.x][point.y] + " minute(s).");
                stringBuilder.append("\n");
                return;
            }
            for (int i = 0; i < 6; i++) {
                nz = point.z + dz[i];
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nz >= 0 && nx >= 0 && ny >= 0 && nz < L && nx < R && ny < C && ch[nz][nx][ny] == 0) {
                    ch[nz][nx][ny] = 1;
                    result[nz][nx][ny] = result[point.z][point.x][point.y] + 1;
                    queue.add(new ThreePoint(nz, nx, ny));
                }
            }
        }
        stringBuilder.append("Trapped!");
        stringBuilder.append("\n");
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


