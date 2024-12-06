package baekjoon.v1.step.binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main02 {
    static int n;
    static int[] ints;
    static int[] ints1;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        n = Integer.parseInt(bufferedReader.readLine());
        ints = new int[n];
        String s = bufferedReader.readLine();
        String[] strings = s.split(" ");
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        Arrays.sort(ints);
        int m = Integer.parseInt(bufferedReader.readLine());
        String s1 = bufferedReader.readLine();
        String[] strings1 = s1.split(" ");
        ints1 = new int[m];
        for (int i = 0; i < m; i++) {
            ints1[i] = Integer.parseInt(strings1[i]);
            stringBuilder.append(back(ints1[i]) - front(ints1[i]) + " ");
        }
        System.out.println(stringBuilder);
    }

    public static int front(int num) {
        int l = 0;
        int r = n;
        while (l < r) {
            int mid = (l + r) / 2;
            if (ints[mid] < num) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

    public static int back(int num) {
        int l = 0;
        int r = n;
        while (l < r) {
            int mid = (l + r) / 2;
            if (ints[mid] <= num) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
