package baekjoon.step.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main08 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[][] strings1 = new String[n][2];
        for (int i = 0; i < n; i++) {
            String s = bufferedReader.readLine();
            String[] strings2 = s.split(" ");
            strings1[i][0] = strings2[0];
            strings1[i][1] = strings2[1];
        }
        int num = 0;
        Arrays.sort(strings1, (s1, s2) -> {
            return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(strings1[i][0] + " ");
            stringBuilder.append(strings1[i][1] + "\n");
        }
        System.out.println(stringBuilder);
    }
}
