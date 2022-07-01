package baekjoon.etc8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main21608 {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int n;
    static int[][] ints;
    static Map<Integer, int[]> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        ints = new int[n][n];
        for (int i = 0; i < n * n; i++) {
            List<Position> list = new ArrayList<>();
            String[] strings = bufferedReader.readLine().split(" ");
            int[] intArray = Arrays.stream(strings).mapToInt(Integer::parseInt).toArray();
            map.put(intArray[0], intArray);
            // 탐색해서 각 포지션별 0값이나 좋아하는 학생 칸 담기
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (ints[j][k] == 0) {
                        direction(j, k, intArray, list);
                    }
                }
            }
            // 단계별로 정렬
            Collections.sort(list, new MyComparator());
            Position position = list.get(0);
            ints[position.x][position.y] = intArray[0];
        }
        // 마지막 만족도 탐색
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int goodCount = 0;
                int[] goodList = map.get(ints[i][j]);
                int nx, ny;
                for (int k = 0; k < 4; k++) {
                    nx = i + dx[k];
                    ny = j + dy[k];
                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        if (ints[nx][ny] == goodList[1] || ints[nx][ny] == goodList[2] || ints[nx][ny] == goodList[3] || ints[nx][ny] == goodList[4]) {
                            goodCount++;
                        }
                    }
                }
                switch (goodCount) {
                    case 1:
                        result += 1;
                        break;
                    case 2:
                        result += 10;
                        break;
                    case 3:
                        result += 100;
                        break;
                    case 4:
                        result += 1000;
                        break;
                }
            }
        }
        System.out.println(result);
    }

    public static void direction(int x, int y, int[] intArray, List<Position> list) {
        int nx, ny;
        int goodCount = 0;
        int emptyCount = 0;
        for (int i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                if (ints[nx][ny] == 0) {
                    emptyCount++;
                } else if (ints[nx][ny] == intArray[1] || ints[nx][ny] == intArray[2] || ints[nx][ny] == intArray[3] || ints[nx][ny] == intArray[4]) {
                    goodCount++;
                }
            }
        }
        list.add(new Position(x, y, goodCount, emptyCount));
    }
}

class MyComparator implements Comparator<Position> {
    int result = 0;

    @Override
    public int compare(Position o1, Position o2) {
        if (o1.goodCount < o2.goodCount) {
            result = 1;
        } else if (o1.goodCount > o2.goodCount) {
            result = -1;
        } else {
            if (o1.emptyCount < o2.emptyCount) {
                result = 1;
            } else if (o1.emptyCount > o2.emptyCount) {
                result = -1;
            } else {
                if (o1.x > o2.x) {
                    result = 1;
                } else if (o1.x < o2.x) {
                    result = -1;
                } else {
                    if (o1.y > o2.y) {
                        result = 1;
                    } else if (o1.y < o2.y) {
                        result = -1;
                    }
                }
            }
        }
        return result;
    }
}

class Position {
    int x;
    int y;
    int goodCount;
    int emptyCount;


    public Position(int x, int y, int goodCount, int emptyCount) {
        this.x = x;
        this.y = y;
        this.goodCount = goodCount;
        this.emptyCount = emptyCount;
    }
}


