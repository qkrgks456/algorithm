package baekjoon.v1.step.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main06 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[][] ints = new int[n][2];
        for (int i = 0; i < n; i++) {
            String s = bufferedReader.readLine();
            String[] strings = s.split(" ");
            ints[i][0] = Integer.parseInt(strings[0]);
            ints[i][1] = Integer.parseInt(strings[1]);
        }
        // 람다식 이해 안된다 근데 이걸 써야만 한단다. 삽입정렬로 하니 시간 초과
        Arrays.sort(ints, (e1, e2) -> {
            if (e1[1] == e2[1]) {
                return e1[0] - e2[0];
            } else {
                return e1[1] - e2[1];
            }
        });
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bufferedWriter.write(ints[i][0] + " " + ints[i][1]);
            bufferedWriter.write("\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
