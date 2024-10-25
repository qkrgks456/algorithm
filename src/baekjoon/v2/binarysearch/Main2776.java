package baekjoon.v2.binarysearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2776 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(bufferedReader.readLine());

        while (T-- > 0) {
            StringBuilder result = new StringBuilder();
            int n = Integer.parseInt(bufferedReader.readLine());
            int[] ints = new int[n];
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i < n; i++) {
                ints[i] = Integer.parseInt(stringTokenizer.nextToken());
            }
            Arrays.sort(ints);
            int m = Integer.parseInt(bufferedReader.readLine());
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int i = 0; i < m; i++) {
                boolean check = false;
                int target = Integer.parseInt(stringTokenizer.nextToken());
                int left = 0;
                int right = ints.length - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (ints[mid] == target) {
                        check = true;
                        break;
                    }
                    if (ints[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                if (check) {
                    result.append(1).append("\n");
                } else {
                    result.append(0).append("\n");
                }
            }
            System.out.print(result);
        }


    }
}
