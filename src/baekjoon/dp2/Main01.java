package baekjoon.dp2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main01 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            int[] ints = new int[num];
            int[] check = new int[num - 1];
            String s = bufferedReader.readLine();
            String[] strings = s.split(" ");
            for (int j = 0; j < num; j++) {
                ints[j] = Integer.parseInt(strings[j]);
            }
            Arrays.sort(ints);
            check[0] = ints[0] + ints[1];
            for (int j = 2; j < ints.length; j++) {
                check[j - 1] = ints[j] + check[j - 2];
                System.out.print(check[j - 1] + " ");
            }
        }
    }
}
