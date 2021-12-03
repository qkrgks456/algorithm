package inflearn.array;


import java.util.Scanner;

public class Main11 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] intArr = new int[num + 1][6];
        for (int i = 1; i <= num; i++) {
            for (int j = 1; j <= 5; j++) {
                intArr[i][j] = scanner.nextInt();
            }
        }
        int cnt = 0, max = 0, result = 0;
        for (int i = 1; i <= num; i++) {
            cnt = 0;
            for (int j = 1; j <= num; j++) {
                for (int k = 1; k <= 5; k++) {
                    if (intArr[i][k] == intArr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt > max) {
                max = cnt;
                result = i;
            }
        }
        System.out.println(result);
    }
}
