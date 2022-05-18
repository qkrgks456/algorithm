package baekjoon.etc6;

import java.util.Scanner;

public class Main2477 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int width = Integer.MIN_VALUE;
        int height = Integer.MIN_VALUE;
        for (int i = 0; i < 6; i++) {
            int direction = scanner.nextInt();
            int length = scanner.nextInt();
            if (direction == 1 || direction == 2) {
                width = Math.max(length, width);
            } else if (direction == 3 || direction == 4) {
                height = Math.max(length, height);
            }
        }
        // 전체 넓이는 구했다 치고, 그러면 남은 부분 직사각형은 어떻게 자르지 ?
        // 여기가 문젠대
        int area = width * height;

    }
}
