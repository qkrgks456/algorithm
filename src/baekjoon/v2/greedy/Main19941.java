package baekjoon.v2.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main19941 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        String s = br.readLine();
        int[] check = new int[n];
        int result = 0;
        for (int i = 0; i < n; i++) {
            int start = i - k;
            int end = i + k;
            if (s.charAt(i) == 'P') {
                for (int j = start; j <= end; j++) {
                    if (j < 0 || j >= n || check[j] == 1) continue;
                    if (s.charAt(j) == 'H') {
                        check[j] = 1;
                        result++;
                        break;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
