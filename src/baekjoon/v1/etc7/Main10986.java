package baekjoon.v1.etc7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10986 {
    // 이해 불가 사망
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        long result = 0;
        long[] mod = new long[m];
        long[] longs = new long[n + 1];
        // 1000000 백만개 가능 아니 이거 뭐냐 개 어렵네 ㅋㅋㅋㅋㅋㅋ
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 1; i <= n; i++) {
            longs[i] = longs[i - 1] + Long.parseLong(stringTokenizer.nextToken());
            if (longs[i] % m == 0) {
                result++;
            }
            mod[(int) (longs[i] % m)] += 1;
        }
        for (int i = 0; i < m; i++) {
            result += mod[i] * (mod[i] - 1) / 2;
        }
        System.out.println(result);
    }
}
