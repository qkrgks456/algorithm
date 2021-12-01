package sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main07 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        int n = Integer.parseInt(str);
        int[][] ints = new int[n][2];
        for (int i = 0; i < n; i++) {
            String str2 = bufferedReader.readLine();
            String[] strings = str2.split(" ");
            for (int j = 0; j < strings.length; j++) {
                ints[i][j] = Integer.parseInt(strings[j]);
            }
        }
        int lt = 0;
        int num = 0;
        int rt = ints.length - 1;
        while (rt > 0) {
            if (ints[lt][0] > ints[lt + 1][0]) {
                num = ints[lt][0];
                ints[lt][0] = ints[lt + 1][0];
                ints[lt + 1][0] = num;
                num = ints[lt][1];
                ints[lt][1] = ints[lt + 1][1];
                ints[lt + 1][1] = num;
            } else if (ints[lt][0] == ints[lt + 1][0]) {
                if (ints[lt][1] > ints[lt + 1][1]) {
                    num = ints[lt][1];
                    ints[lt][1] = ints[lt + 1][1];
                    ints[lt + 1][1] = num;
                }
            }
            lt++;
            if (lt == rt) {
                rt--;
                lt = 0;
            }
        }
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i][0] + " " +ints[i][1]);
            System.out.println();
        }
    }
}
