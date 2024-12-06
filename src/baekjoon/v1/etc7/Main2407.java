package baekjoon.v1.etc7;

import java.math.BigInteger;
import java.util.Scanner;

public class Main2407 {
    public static void main(String[] args) {
        // dp로 조합 공식 이용해보자
        // 아 공식은 맞는데 수를 담을수가 있나 이게 ??
        // 나머지 연산 하라는것도 아니구
        String[][] strings = new String[101][101];
        strings[1][0] = "1";
        strings[1][1] = "1";
        for (int i = 2; i < strings.length; i++) {
            strings[i][0] = "1";
            strings[i][i] = "1";
            for (int j = 1; j < i; j++) {
                BigInteger n1 = new BigInteger(strings[i - 1][j - 1]);
                BigInteger n2 = new BigInteger(strings[i - 1][j]);
                strings[i][j] = n1.add(n2).toString();
            }
        }
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        System.out.println(strings[n][r]);
    }

}
