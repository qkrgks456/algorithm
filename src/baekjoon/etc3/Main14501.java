package baekjoon.etc3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14501 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] T = new int[n + 2];
        int[] P = new int[n + 2];
        int[] result = new int[n + 2];
        for (int i = 1; i < n + 1; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            T[i] = Integer.parseInt(stringTokenizer.nextToken());
            P[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int i = n; i > 0; i--) {
            if (i + T[i] > n + 1) { // 일할 수 있는 날짜를 넘어가는 경우
                result[i] = result[i + 1];
            } else {    // 돈을 더 많이 버는 경우를 게산
                result[i] = Math.max(result [i + 1], result[i + T[i]] + P[i]);
            }
        }
        System.out.println(result[1]);

    }
}
