package inflearn.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main10 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        int inputNum = Integer.parseInt(input);
        int[][] intArr = new int[inputNum + 2][inputNum + 2];
        for (int i = 1; i <= intArr.length - 2; i++) {
            String input1 = bufferedReader.readLine();
            String[] strArr = input1.split(" ");
            for (int j = 1; j <= intArr[i].length - 2; j++) {
                intArr[i][j] = Integer.parseInt(strArr[j - 1]);
            }
        }
        int top = 0;
        int bottom = 0;
        int left = 0;
        int right = 0;
        int center = 0;
        int result = 0;
        for (int i = 1; i <= intArr.length - 2; i++) {
            for (int j = 1; j <= intArr[i].length - 2; j++) {
                center = intArr[i][j];
                top = intArr[i - 1][j];
                bottom = intArr[i + 1][j];
                left = intArr[i][j - 1];
                right = intArr[i][j + 1];
                if (center > top && center > bottom && center > left && center > right) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
