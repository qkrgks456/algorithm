package baekjoon.etc9;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class Main19238 {
    static int N, M, G;
    static int[][] ints, ch, distance;
    static Car car;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static Map<Integer, Map<Integer, Point>> map = new HashMap<>();

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
        car = new Car(x, y, G);
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int sx = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int sy = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int ex = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            int ey = Integer.parseInt(stringTokenizer.nextToken()) - 1;
            ints[sx][sy] = 2;
            Map<Integer, Point> maps = new HashMap<>();
            maps.put(sy, new Point(ex, ey));
            map.put(sx, maps);
        }
        BFS(x, y);
    }

    public static void BFS(int x, int y) {
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
                        if (ints[nx][ny] == 2) {
                            list.add(new Person(nx, ny));
                        }
                        queue.add(new Point(nx, ny));
                    }
                }
            }
            if (list.size() > 0) {
                Collections.sort(list, new MyComparator());
                System.out.println(list);
                return;
            }
        }
    }
}

class Car {
    int x;
    int y;
    int gas;

    public Car(int x, int y, int gas) {
        this.x = x;
        this.y = y;
        this.gas = gas;
    }
}

class MyComparator implements Comparator<Person> {
    int result = 0;

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.x < o2.x) {
            result = 1;
        } else if (o1.x > o2.x) {
            result = -1;
        } else {
            if (o1.y < o2.y) {
                result = 1;
            } else if (o1.y > o2.y) {
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
