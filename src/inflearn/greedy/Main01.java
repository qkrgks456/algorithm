package inflearn.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main01 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] ints = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] strings = bufferedReader.readLine().split(" ");
            ints[i][0] = Integer.parseInt(strings[0]);
            ints[i][1] = Integer.parseInt(strings[1]);
        }
        Arrays.sort(ints, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o2[1] - o1[1];
            } else {
                return o2[0] - o1[0];
            }
        });
        int check = ints[0][1];
        int result = 1;
        for (int i = 1; i < n; i++) {
            if (check < ints[i][1]) {
                result++;
                check = ints[i][1];
            }
        }
        System.out.println(result);
    }
}
