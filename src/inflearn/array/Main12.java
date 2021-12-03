package inflearn.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main12 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input1 = bufferedReader.readLine();
        String[] strArr = input1.split(" ");
        int[][] intArr = new int[Integer.parseInt(strArr[1])][Integer.parseInt(strArr[0])];
        for (int i = 0; i < intArr.length; i++) {
            String input2 = bufferedReader.readLine();
            String[] strArr2 = input2.split(" ");
            for (int j = 0; j < intArr[i].length; j++) {
                intArr[i][j] = Integer.parseInt(strArr2[j]);
            }
        }
        int[][] checkArr = new int[Integer.parseInt(strArr[0]) + 1][Integer.parseInt(strArr[0]) + 1];

        for (int k = 1; k <= Integer.parseInt(strArr[0]); k++) {
            for (int i = 0; i < intArr.length; i++) {
                boolean check = false;
                for (int j = 0; j < intArr[i].length; j++) {
                    if (check) {
                        checkArr[k][intArr[i][j]]++;
                    }
                    if (intArr[i][j] == k) {
                        check = true;
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < checkArr.length; i++) {
            for (int j = 0; j < checkArr[i].length; j++) {
                if (checkArr[i][j] == Integer.parseInt(strArr[1])) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}

