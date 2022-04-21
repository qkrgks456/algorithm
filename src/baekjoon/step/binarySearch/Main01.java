package baekjoon.step.binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main01 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] ints = new int[n];
        String s = bufferedReader.readLine();
        String[] strings = s.split(" ");
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        Arrays.sort(ints);
        int m = Integer.parseInt(bufferedReader.readLine());
        String s1 = bufferedReader.readLine();
        String[] strings1 = s1.split(" ");
        int[] ints1 = new int[m];
        for (int i = 0; i < m; i++) {
            ints1[i] = Integer.parseInt(strings1[i]);
        }
        for (int i = 0; i < ints1.length; i++) {
            int l = 0;
            int r = n - 1;
            int mid = r / 2;
            boolean check = true;
            if (ints[l] == ints1[i] || ints[r] == ints1[i]) {
                stringBuilder.append(1 + "\n");
                continue;
            }
            while (l != r - 1) {
                if (ints[mid] == ints1[i]) {
                    check = false;
                    stringBuilder.append(1 + "\n");
                    break;
                } else if (ints[mid] < ints1[i]) {
                    l = mid;
                } else if (ints[mid] > ints1[i]) {
                    r = mid;
                }
                mid = (l + r) / 2;
            }
            if (check) {
                stringBuilder.append(0 + "\n");
            }
        }
        System.out.println(stringBuilder);
    }
}
