package baekjoon.v1.etc6;

import java.util.Scanner;

public class Main2477 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int widthIndex = 0;
        int heightIndex = 0;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int[] check = new int[6];
        for (int i = 0; i < 6; i++) {
            int direction = scanner.nextInt();
            int length = scanner.nextInt();
            if (direction == 1 || direction == 2) {
                if (length > max1) {
                    widthIndex = i;
                    max1 = length;
                }
            } else if (direction == 3 || direction == 4) {
                if (length > max2) {
                    heightIndex = i;
                    max2 = length;
                }
            }
            check[i] = length;
        }
        // 앞뒤 인덱스를 구해야 하는데
        // 여기가 문젠대
        int area = check[widthIndex] * check[heightIndex];
        int n1 = widthIndex + 1 >= check.length ? 0 : widthIndex + 1;
        int n2 = widthIndex - 1 < 0 ? check.length - 1 : widthIndex - 1;
        int n3 = heightIndex + 1 >= check.length ? 0 : heightIndex + 1;
        int n4 = heightIndex - 1 < 0 ? check.length - 1 : heightIndex - 1;
        int resultWidth = check[heightIndex] - Math.min(check[n1], check[n2]);
        int resultHeight = check[widthIndex] - Math.min(check[n3], check[n4]);
        System.out.println(n * (area - resultWidth * resultHeight));
    }
}
