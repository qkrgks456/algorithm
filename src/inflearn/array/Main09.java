package inflearn.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main09 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input = bufferedReader.readLine();
        int inputNum = Integer.parseInt(input);
        int[][] intArr = new int[inputNum][inputNum];
        for (int i = 0; i < inputNum; i++) {
            String input1 = bufferedReader.readLine();
            String[] strArr = input1.split(" ");
            for (int j = 0; j < inputNum; j++) {
                intArr[i][j] = Integer.parseInt(strArr[j]);
            }
        }
        int rowMax = 0;
        int colMax = 0;
        int leftMax = 0;
        int rightMax = 0;
        for (int i = 0; i < intArr.length; i++) {
            int rowPlus = 0;
            int colPlus = 0;
            for (int j = 0; j < intArr[i].length; j++) {
                if (i == j) {
                    leftMax += intArr[i][j];
                }
                rowPlus += intArr[i][j];
                colPlus += intArr[j][i];
                if (rowMax < rowPlus) {
                    rowMax = rowPlus;
                }
                if (colMax < colPlus) {
                    colMax = colPlus;
                }
            }
        }
        int num = intArr.length - 1;
        for (int i = 0; i < intArr.length; i++) {
            rightMax += intArr[i][num];
            num--;
        }
        int[] maxArr = new int[4];
        maxArr[0] = rowMax;
        maxArr[1] = colMax;
        maxArr[2] = leftMax;
        maxArr[3] = rightMax;
        int result = rowMax;
        for (int i = 1; i < maxArr.length; i++) {
            if (result < maxArr[i]) {
                result = maxArr[i];
            }
        }
        System.out.println(result);
    }
}
