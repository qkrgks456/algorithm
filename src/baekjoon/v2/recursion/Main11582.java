package baekjoon.v2.recursion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main11582 {

    static StringBuilder stringBuilder = new StringBuilder();
    static int[] ints;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        int k = Integer.parseInt(bufferedReader.readLine());

        int size = n / k;
        for (int i = 0; i < n; i += size) {
            sort(i, i + size);
        }

        System.out.println(stringBuilder);
    }

    public static void sort(int start, int end) {
        List<Integer> list = new ArrayList<>();
        for (int i = start; i < end; i++) {
            list.add(ints[i]);
        }
        Collections.sort(list);
        for (int num : list) {
            stringBuilder.append(num).append(" ");
        }
    }


}
