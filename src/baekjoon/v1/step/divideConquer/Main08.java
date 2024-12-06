package baekjoon.v1.step.divideConquer;

import java.util.Scanner;

public class Main08 {
    static long[][] longs = {{1, 1}, {1, 0}};
    static int bigNum = 1000000007;

    //1000000007
    //1000000000000000000
    public static void main(String[] args) throws Exception {
        // 이건 거의 불가 수준
        // 피보나치 수를 행렬식으로 바꿔주는 과정이 정말 너무 어려움
        // 스스로 생각해볼 수 없었을것 같다 당분간 티어 낮은걸로 자존감 회복을 해야할듯 하다
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        long[][] longs = DFS(num);
        System.out.println(longs[1][0]);
    }

    public static long[][] DFS(long num) {
        if (num == 1) {
            return longs;
        }
        long[][] check = DFS(num / 2);
        if (num % 2 == 0) {
            return multi(check, check);
        }
        return multi(multi(check, check), longs);
    }

    public static long[][] multi(long[][] matrix, long[][] matrix2) {
        long[][] result = new long[2][2];
        result[0][0] = ((matrix[0][0] * matrix2[0][0] % bigNum) + (matrix[0][1] * matrix2[1][0] % bigNum)) % bigNum;
        result[0][1] = ((matrix[0][0] * matrix2[1][0] % bigNum) + (matrix[0][1] * matrix2[1][1] % bigNum)) % bigNum;
        result[1][0] = ((matrix[1][0] * matrix2[0][0] % bigNum) + (matrix[1][1] * matrix2[1][0] % bigNum)) % bigNum;
        result[1][1] = ((matrix[1][0] * matrix2[0][1] % bigNum) + (matrix[1][1] * matrix2[1][1] % bigNum)) % bigNum;
        return result;
    }
}
