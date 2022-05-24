package baekjoon.etc7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1004 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int startX = Integer.parseInt(stringTokenizer.nextToken());
            int startY = Integer.parseInt(stringTokenizer.nextToken());
            int endX = Integer.parseInt(stringTokenizer.nextToken());
            int endY = Integer.parseInt(stringTokenizer.nextToken());
            int n1 = Integer.parseInt(bufferedReader.readLine());
            for (int j = 0; j < n1; j++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                int x = Integer.parseInt(stringTokenizer.nextToken());
                int y = Integer.parseInt(stringTokenizer.nextToken());
                int r = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
    }
}

class Circle {
    int x;
    int y;
    int r;

    public Circle(int x, int y, int r) {
        this.x = x;
        this.y = y;
        this.r = r;
    }
}
