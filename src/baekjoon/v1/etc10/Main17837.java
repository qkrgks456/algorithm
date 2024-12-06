package baekjoon.v1.etc10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main17837 {
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0};
    static int n, k;
    static Chass[] chasses;
    static int[][] ints;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());
        List<Integer>[][] lists = new LinkedList[n][n];
        chasses = new Chass[k + 1];
        ints = new int[n][n];
        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < n; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                lists[i][j] = new LinkedList<>();
            }
        }
        for (int i = 1; i <= k; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int y = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int d = Integer.parseInt(stringTokenizer.nextToken());
            lists[x][y].add(i);
            chasses[i] = new Chass(x, y, d, i);
        }
        int result = 0;
        while (true) {
            if (result > 1000) {
                System.out.println(-1);
                System.exit(0);
            }
            result++;
            for (int i = 1; i <= k; i++) {
                Chass chass = chasses[i];
                int nx = chass.x + dx[chass.d];
                int ny = chass.y + dy[chass.d];
                // 맵 벗어나거나 퍼런색이라면
                if (nx < 0 || ny < 0 || nx == n || ny == n || ints[nx][ny] == 2) {
                    // 방향 뒤집고
                    if (chass.d == 1 || chass.d == 2) {
                        chass.d = chass.d - 1 == 1 ? 1 : 2;
                    } else {
                        chass.d = chass.d - 1 == 3 ? 3 : 4;
                    }
                    nx = chass.x + dx[chass.d];
                    ny = chass.y + dy[chass.d];
                }
                // 일단 그게 또 벗어나지는 않는지 확인
                if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    // 하얀색이라면
                    if (ints[nx][ny] == 0) {
                        boolean check = false;
                        List<Integer> del = new ArrayList<>();
                        for (Integer num : lists[chass.x][chass.y]) {
                            if (num == i) {
                                check = true;
                            }
                            if (check) {
                                lists[nx][ny].add(num);
                                del.add(num);
                            }
                        }
                        for (Integer num : del) {
                            lists[chasses[num].x][chasses[num].y].remove(num);
                            chasses[num].x = nx;
                            chasses[num].y = ny;
                        }
                    } else if (ints[nx][ny] == 1) {
                        List<Integer> del = new ArrayList<>();
                        List<Integer> list = lists[chass.x][chass.y];
                        for (int j = list.size() - 1; j >= 0; j--) {
                            Integer num = list.get(j);
                            lists[nx][ny].add(num);
                            del.add(num);
                            if (num == i) {
                                break;
                            }
                        }
                        for (Integer num : del) {
                            lists[chasses[num].x][chasses[num].y].remove(num);
                            chasses[num].x = nx;
                            chasses[num].y = ny;
                        }
                    }
                }
                for (int j = 1; j <= k; j++) {
                    if (lists[chasses[j].x][chasses[j].y].size() >= 4) {
                        System.out.println(result);
                        System.exit(0);
                    }
                }
            }
        }
    }
}

class Chass {
    int x;
    int y;
    int d;
    int no;


    public Chass(int x, int y, int d, int no) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.no = no;
    }

    @Override
    public String toString() {
        return "Chass{" +
                "x=" + x +
                ", y=" + y +
                ", d=" + d +
                ", no=" + no +
                '}';
    }
}
