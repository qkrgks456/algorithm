package baekjoon.v1.etc7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main16139 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        int n = Integer.parseInt(bufferedReader.readLine());
        List<int[]> list = new ArrayList<>();
        // 97 빼믄 인덱스 나온다
        for (char i = 'a'; i <= 'z'; i++) {
            int[] ints = new int[s.length()];
            if (i == s.charAt(0)) {
                ints[0] = 1;
            }
            for (int j = 1; j < ints.length; j++) {
                if (i == s.charAt(j)) {
                    ints[j]++;
                }
                ints[j] += ints[j - 1];
            }
            list.add(ints);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            char c = stringTokenizer.nextToken().charAt(0);
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            int[] result = list.get((int) c - 97);
            if (start == 0) {
                stringBuilder.append(result[end] + "\n");
            } else {
                stringBuilder.append(result[end] - result[start - 1] + "\n");
            }
        }
        System.out.println(stringBuilder);
    }
}
