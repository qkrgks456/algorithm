package baekjoon.v1.etc4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main15829 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] ints = new int[n];
        String s = bufferedReader.readLine();
        for (int i = 0; i < ints.length; i++) {
            ints[i] = s.charAt(i) - 96;
        }
        long num = 0;
        long pow = 1;
        for (int i = 0; i < ints.length; i++) {
            num += ints[i] * pow;
            pow = pow * 31 % 1234567891;
        }
        System.out.println(num);
    }
}
