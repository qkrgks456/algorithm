package baekjoon.v1.etc10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main19237 {
    static int dx[] = {0, -1, 1, 0, 0};
    static int dy[] = {0, 0, 0, -1, 1};
    static int N, M, k;
    static Smell[][] smells;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        k = Integer.parseInt(stringTokenizer.nextToken());
        Shark[] list = new Shark[M + 1];
        List<Integer>[][] ints = new ArrayList[N][N];
        smells = new Smell[N][N];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                int num = Integer.parseInt(stringTokenizer.nextToken());
                ints[i][j] = new ArrayList<>();
                if (num != 0) {
                    list[num] = new Shark(i, j, 0, num);
                    smells[i][j] = new Smell(num, k);
                    ints[i][j].add(num);
                }
            }
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= M; i++) {
            int direction = Integer.parseInt(stringTokenizer.nextToken());
            Shark shark = list[i];
            shark.d = direction;
        }
        int[][][] priority = new int[M + 1][5][5];
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= 4; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int l = 1; l <= 4; l++) {
                    priority[i][j][l] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }
        }
        for (int i = 1; i <= M; i++) {
            Shark shark = list[i];
            shark.priority = priority[i];
        }

        for (int i = 1; i <= 1000; i++) {
            // 상어 이동
            for (Shark shark : list) {
                if (shark == null) {
                    continue;
                }
                int nx, ny;
                boolean smellCheck = false;
                // 4방향 내 냄새 몇개 있는지 확인
                for (int j = 1; j <= 4; j++) {
                    nx = shark.x + dx[j];
                    ny = shark.y + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        Smell smell = smells[nx][ny];
                        if (smell == null) {
                            smellCheck = true;
                        }
                    }
                }
                int[] direction = shark.getDirection();
                if (smellCheck) {
                    // 주위에 아무냄새가 없는 칸이 존재함
                    for (int j = 1; j < direction.length; j++) {
                        nx = shark.x + dx[direction[j]];
                        ny = shark.y + dy[direction[j]];
                        if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                            if (smells[nx][ny] == null) {
                                // 실제 이동
                                Integer integer = shark.num;
                                ints[shark.x][shark.y].remove(integer);
                                ints[nx][ny].add(shark.num);
                                shark.x = nx;
                                shark.y = ny;
                                shark.d = direction[j];
                                break;
                            }
                        }
                    }
                } else {
                    // 주위가 모두 냄새가 있는 칸
                    for (int j = 1; j < direction.length; j++) {
                        nx = shark.x + dx[direction[j]];
                        ny = shark.y + dy[direction[j]];
                        if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                            if (shark.num == smells[nx][ny].num) {
                                // 실제 이동
                                Integer integer = shark.num;
                                ints[shark.x][shark.y].remove(integer);
                                ints[nx][ny].add(shark.num);
                                shark.x = nx;
                                shark.y = ny;
                                shark.d = direction[j];
                                break;
                            }
                        }
                    }
                }
            }
            // 이동후에 스멜 제거
            for (int j = 0; j < N; j++) {
                for (int l = 0; l < N; l++) {
                    if (smells[j][l] != null) {
                        smells[j][l].count--;
                        if (smells[j][l].count == 0) {
                            smells[j][l] = null;
                        }
                    }
                }
            }

            // 이동 끝났으면 중복되는애들 제일 낮은애 빼고 없애기
            // 플러스 스멜 추가해주기
            for (int j = 0; j < N; j++) {
                for (int l = 0; l < N; l++) {
                    if (ints[j][l].size() > 0) {
                        Collections.sort(ints[j][l]);
                        for (int m = 1; m < ints[j][l].size(); m++) {
                            List<Integer> integers = ints[j][l];
                            list[integers.get(m)] = null;
                            integers.remove(m);
                            m--;
                        }
                        smells[j][l] = new Smell(ints[j][l].get(0), k);
                    }
                }
            }
            int count = 0;
            for (int j = 0; j < N; j++) {
                for (int l = 0; l < N; l++) {
                    if (ints[j][l].size() > 0) {
                        count++;
                    }
                }
            }
            if (count == 1) {
                System.out.println(i);
                System.exit(0);
            }
        }
        System.out.println(-1);
    }
}

class Shark {
    int x;
    int y;
    int d;
    int num;
    int[][] priority;

    public Shark(int x, int y, int d, int num) {
        this.x = x;
        this.y = y;
        this.d = d;
        this.num = num;
    }

    public int[] getDirection() {
        int[] ints = new int[5];
        for (int i = 1; i < priority.length; i++) {
            ints[i] = priority[this.d][i];
        }
        return ints;
    }
}

class Smell {
    int num;
    int count;

    public Smell(int num, int count) {
        this.num = num;
        this.count = count;
    }

    @Override
    public String toString() {
        return "Smell{" +
                "num=" + num +
                ", count=" + count +
                '}';
    }
}
