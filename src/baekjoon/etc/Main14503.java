package baekjoon.etc;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class ThreePoint {
    public int x;
    public int y;
    public int status;

    public ThreePoint(int x, int y, int status) {
        this.x = x;
        this.y = y;
        this.status = status;
    }
}

public class Main14503 {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    static int[][] ints, check;
    static int n, m;
    static int result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        n = Integer.parseInt(strings[0]);
        m = Integer.parseInt(strings[1]);
        String[] strings1 = bufferedReader.readLine().split(" ");
        int startX = Integer.parseInt(strings1[0]);
        int startY = Integer.parseInt(strings1[1]);
        int status = Integer.parseInt(strings1[2]);
        ints = new int[n][m];
        check = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] strings2 = bufferedReader.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                ints[i][j] = Integer.parseInt(strings2[j]);
                check[i][j] = Integer.parseInt(strings2[j]);
            }
        }
        BFS(startX, startY, status);
        System.out.println(result);
    }

    public static void BFS(int x, int y, int st) {
        // 0 북 1 동 2 남 3 서
        Queue<ThreePoint> queue = new LinkedList<>();
        queue.add(new ThreePoint(x, y, st));
        result++;
        check[x][y] = 1;
        while (!queue.isEmpty()) {
            ThreePoint point = queue.poll();
            if (point.x + 1 < n && point.x - 1 >= 0 && point.y + 1 < m && point.y - 1 >= 0) {
                if (check[point.x + 1][point.y] == 1 && check[point.x - 1][point.y] == 1 && check[point.x][point.y + 1] == 1 && check[point.x][point.y - 1] == 1) {
                    if (point.status == 0) {
                        if (ints[point.x + 1][point.y] == 1) {
                            break;
                        }
                        queue.add(new ThreePoint(point.x + 1, point.y, 0));
                    } else if (point.status == 1) {
                        if (ints[point.x - 1][point.y] == 1) {
                            break;
                        }
                        queue.add(new ThreePoint(point.x - 1, point.y, 1));
                    } else if (point.status == 2) {
                        if (ints[point.x][point.y - 1] == 1) {
                            break;
                        }
                        queue.add(new ThreePoint(point.x, point.y - 1, 2));
                    } else {
                        if (ints[point.x][point.y + 1] == 1) {
                            break;
                        }
                        queue.add(new ThreePoint(point.x, point.y + 1, 3));
                    }
                } else {
                    if (point.status == 0) {
                        if (check[point.x - 1][point.y] == 0) {
                            check[point.x - 1][point.y] = 1;
                            result++;
                            queue.add(new ThreePoint(point.x - 1, point.y, 3));
                        } else {
                            queue.add(new ThreePoint(point.x, point.y, 3));
                        }
                    } else if (point.status == 1) {
                        if (check[point.x][point.y - 1] == 0) {
                            check[point.x][point.y - 1] = 1;
                            result++;
                            queue.add(new ThreePoint(point.x, point.y - 1, 3));
                        } else {
                            queue.add(new ThreePoint(point.x, point.y, 3));
                        }
                    } else if (point.status == 2) {
                        if (check[point.x][point.y + 1] == 0) {
                            check[point.x][point.y + 1] = 1;
                            result++;
                            queue.add(new ThreePoint(point.x, point.y + 1, 3));
                        } else {
                            queue.add(new ThreePoint(point.x, point.y, 3));
                        }
                    } else {
                        if (check[point.x + 1][point.y] == 0) {
                            check[point.x + 1][point.y] = 1;
                            result++;
                            queue.add(new ThreePoint(point.x + 1, point.y, 3));
                        } else {
                            queue.add(new ThreePoint(point.x, point.y, 3));
                        }
                    }
                }
            }

        }
    }
}
