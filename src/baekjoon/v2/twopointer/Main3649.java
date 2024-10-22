package baekjoon.v2.twopointer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main3649 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while ((input = bufferedReader.readLine()) != null) {
            int x = Integer.parseInt(input) * 10000000;
            String input2 = bufferedReader.readLine();
            int n = Integer.parseInt(input2);
            int[] ints = new int[n];
            for (int i = 0; i < n; i++) {
                String input3 = bufferedReader.readLine();
                if (input3 == null) break;
                ints[i] = Integer.parseInt(input3);
            }
            Arrays.sort(ints);
            int start = 0;
            int end = n - 1;
            int max = Integer.MIN_VALUE;
            int[] result = new int[2];
            boolean check = false;
            while (start < end) {
                int curSum = ints[start] + ints[end];
                if (curSum > x) {
                    end--;
                } else if (curSum < x) {
                    start++;
                } else {
                    check = true;
                    result[0] = ints[start];
                    result[1] = ints[end];
                    break;
                }
            }
            if (check) {
                System.out.println("yes " + result[0] + " " + result[1]);
            } else {
                System.out.println("danger");
            }
        }


    }
}
