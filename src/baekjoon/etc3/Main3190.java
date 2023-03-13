package baekjoon.etc3;

import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main3190 {
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {1, 0, -1, 0};
    static int[][] ints;
    static int N;
    static char[] chars;

    // 아니 거의다 왔는데 진짜 개 열받게 계속 틀리네 ㅡ.ㅡ
    public static void main(String[] args) throws Exception {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());
        ints = new int[N][N];
        chars = new char[10001];
        int K = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n1 = Integer.parseInt(stringTokenizer.nextToken());
            int n2 = Integer.parseInt(stringTokenizer.nextToken());
            ints[n1 - 1][n2 - 1] = 4;
        }
        int L = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int num = Integer.parseInt(stringTokenizer.nextToken());
            char c = stringTokenizer.nextToken().charAt(0);
            chars[num] = c;
        }
        snake();
    }

    public static void snake() {
        Deque<Point> deque = new LinkedList<>();
        deque.addLast(new Point(0, 0));
        ints[0][0] = 1;
        int count = 0;
        int check = 0;
        while (true) {
            count++;
            Point cur = deque.peekLast();
            Point next = new Point(cur.x + dx[check], cur.y + dy[check]);
            // 넘어가거나 몸이 만나면
            if (next.x < 0 || next.y < 0 || next.x >= N || next.y >= N || ints[next.x][next.y] == 1) {
                break;
            }
            if (ints[next.x][next.y] != 4) {
                Point tail = deque.removeFirst();
                ints[tail.x][tail.y] = 0;
            }
            deque.addLast(next);
            ints[next.x][next.y] = 1;
            // 방향 선정
            if ((int) chars[count] != 0) {
                if (chars[count] == 'D') {
                    check--;
                    if (check == -1) check = 3;
                } else if (chars[count] == 'L') {
                    check++;
                    if (check == 4) check = 0;
                }
            }
        }
        System.out.println(count);
    }
}
