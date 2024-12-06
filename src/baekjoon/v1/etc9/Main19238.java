package baekjoon.v1.etc9;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Queue;
import java.util.*;

public class Main19238 {
    static int N, M, G;
    static int[][] ints, ch, distance;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Map<Key, Point> map = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        G = Integer.parseInt(stringTokenizer.nextToken());
        ints = new int[N][N];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                ints[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int x = Integer.parseInt(stringTokenizer.nextToken()) - 1;
        int y = Integer.parseInt(stringTokenizer.nextToken()) - 1;
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int sx = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int sy = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int ex = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int ey = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            ints[sx][sy] = 2;
            map.put(new Key(sx, sy), new Point(ex, ey));
        }

        for (int i = 0; i < M; i++) {
            Point point = startBFS(x, y);
            x = point.x;
            y = point.y;
        }
        System.out.println(G);
    }

    public static Point startBFS(int x, int y) {
        if (ints[x][y] == 2) {
            ints[x][y] = 0;
            Point end = map.get(new Key(x, y));
            return endBFS(x, y, end);
        }
        Queue<Point> queue = new LinkedList<>();
        ch = new int[N][N];
        distance = new int[N][N];
        ch[x][y] = 1;
        queue.add(new Point(x, y));
        int nx, ny;
        while (!queue.isEmpty()) {
            List<Person> list = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                for (int j = 0; j < 4; j++) {
                    nx = point.x + dx[j];
                    ny = point.y + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && ch[nx][ny] == 0 && ints[nx][ny] != 1) {
                        ch[nx][ny] = 1;
                        distance[nx][ny] = distance[point.x][point.y] + 1;
                        queue.add(new Point(nx, ny));
                        // 같은거리면 리스트에 넣기
                        if (ints[nx][ny] == 2) {
                            list.add(new Person(nx, ny));
                        }
                    }
                }
            }
            // 출발 손님이 있다면
            if (list.size() > 0) {
                // 정렬해서 0번이 행이 작고 같다면 열이 가장 작은 손님
                list.sort(new MyComparator());
                Person start = list.get(0);
                // 연료 소모시켜서 확인하기
                G -= distance[start.x][start.y];
                ints[start.x][start.y] = 0;
                if (G < 0) {
                    System.out.println(-1);
                    System.exit(0);
                }
                Point end = map.get(new Key(start.x, start.y));
                return endBFS(start.x, start.y, end);
            }
        }
        // 없으면 -1 종료
        System.out.println(-1);
        System.exit(0);
        return null;
    }

    private static Point endBFS(int x, int y, Point end) {
        Queue<Point> queue = new LinkedList<>();
        ch = new int[N][N];
        distance = new int[N][N];
        ch[x][y] = 1;
        queue.add(new Point(x, y));
        int nx, ny;
        while (!queue.isEmpty()) {
            Point point = queue.poll();
            for (int i = 0; i < 4; i++) {
                nx = point.x + dx[i];
                ny = point.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < N && ny < N && ch[nx][ny] == 0 && ints[nx][ny] != 1) {
                    ch[nx][ny] = 1;
                    distance[nx][ny] = distance[point.x][point.y] + 1;
                    queue.add(new Point(nx, ny));
                    if (nx == end.x && ny == end.y) {
                        G -= distance[nx][ny];
                        if (G < 0) {
                            System.out.println(-1);
                            System.exit(0);
                        }
                        G += distance[nx][ny] * 2;
                        return end;
                    }
                }
            }
        }
        System.out.println(-1);
        System.exit(0);
        return null;
    }
}

class MyComparator implements Comparator<Person> {
    int result = 0;

    @Override
    public int compare(Person o1, Person o2) {
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
        return result;
    }
}

class Person {
    int x;
    int y;

    public Person(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Person{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Key {

    private final int x;
    private final int y;

    public Key(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Key)) return false;
        Key key = (Key) o;
        return x == key.x && y == key.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

}
