package baekjoon.etc5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main6064 {
    // 아니 이게 어떻게 실버1이야 ??
    // 구현도 열받고 유클리드 호제법에 DP,구현,DFS,BFS보다 어려운데 아 진짜 열받는다
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int M = Integer.parseInt(stringTokenizer.nextToken());
            int N = Integer.parseInt(stringTokenizer.nextToken());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            int x2 = x;
            int cnt = x;
            // 최소공배수
            for (int j = 0; j < N; j++) {
                int num = x2 % N == 0 ? N : x2 % N;
                if (num == y) break;
                x2 += M;
                cnt += M;
            }
            if (cnt > N * M / gcd(M, N)) {
                cnt = -1;
            }
            stringBuilder.append(cnt + "\n");
        }
        System.out.println(stringBuilder);
    }

    // 최대공약수
    public static int gcd(int n1, int n2) {
        while (true) {
            if (n2 == 0) break;
            int num = n1 % n2;
            n1 = n2;
            n2 = num;
        }
        return n1;
    }
}
