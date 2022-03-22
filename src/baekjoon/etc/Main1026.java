package baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main1026 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] first = new int[n];
        Integer[] second = new Integer[n];
        String[] strings = bufferedReader.readLine().split(" ");
        String[] strings1 = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            first[i] = Integer.parseInt(strings[i]);
            second[i] = Integer.parseInt(strings1[i]);
        }
        Arrays.sort(first);
        Arrays.sort(second, Collections.reverseOrder());
        int result = 0;
        for (int i = 0; i < n; i++) {
            result += second[i] * first[i];
        }
        System.out.println(result);
    }
}
