package baekjoon.v2.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2231 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] ints = new int[1000001];
        for (int i = 1; i <= n; i++) {
            String str = String.valueOf(i);
            String[] strings = str.split("");
            int sum = 0;
            for (String string : strings) {
                sum += Integer.parseInt(string);
            }
            ints[i] = sum + i;
        }
        for (int i = 1; i <= n; i++) {
            if(ints[i] == n){
                System.out.println(i);
                return;
            }
        }
        System.out.println(0);
    }

}
