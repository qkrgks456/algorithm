package baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main1026 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] first = new int[n];
        int[] second = new int[n];
        int[] result = new int[n];
        String[] strings = bufferedReader.readLine().split(" ");
        String[] strings1 = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            first[i] = Integer.parseInt(strings[i]);
            second[i] = Integer.parseInt(strings1[i]);
        }
        Arrays.sort(first);
        for (int i = n - 1; i >= 0; i--) {
            System.out.print(first[i] + " ");
        }
    }
}
