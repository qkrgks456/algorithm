package baekjoon.etc6;

import java.util.Scanner;

public class Main2477 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int widthIndex = 0;
        int heightIndex = 0;
        int max1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int[] check = new int[6];
        for (int i = 0; i < 6; i++) {
            int direction = scanner.nextInt();
            int length = scanner.nextInt();
            if (direction == 1 || direction == 2) {
                if (length > max1) {
                    widthIndex = i;
                }
            } else if (direction == 3 || direction == 4) {
                if (length > max2) {
                    heightIndex = i;
                }
            }
            check[i] = direction;
        }
        // 전체 넓이는 구했다 치고, 그러면 남은 부분 직사각형은 어떻게 자르지 ?
        // 여기가 문젠대
        int area = check[widthIndex] * check[heightIndex];
        int w1 = widthIndex + 1;
        int w2 = widthIndex - 1;
        int h1 = heightIndex + 1;
        int h2 = heightIndex - 1;
        int n1 = 0;
        int n2 = 0;
        if (w1 >= check.length) {
            n1 = 0;
        } else {
            n1 = w1;
        }
        if (w2 < 0) {
            n2 = check.length - 1;
        } else {
            n2 = w2;
        }
        int widthResult = Math.min(n1, n2);
        n1 = 0;
        n2 = 0;
        if (h1 >= check.length) {
            n1 = 0;
        } else {
            n1 = h1;
        }
        if (h2 < 0) {
            n2 = check.length - 1;
        } else {
            n2 = h2;
        }
        int heightResult = Math.min(n1, n2);
        System.out.println(n * (area - (widthResult * heightResult)));
    }
}
