package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];
        int max = Integer.MIN_VALUE;
        int num = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = Math.max(arr[i], max);
                num = i + 1;
            }
        }
        System.out.println(max);
        System.out.println(num);
    }
}
