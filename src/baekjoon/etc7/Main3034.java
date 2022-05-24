package baekjoon.etc7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3034 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int W = Integer.parseInt(stringTokenizer.nextToken());
        int H = Integer.parseInt(stringTokenizer.nextToken());
        // 삼각형 선분 구하기
        int n1 = (int) Math.pow(W, 2);
        int n2 = (int) Math.pow(H, 2);
        int n3 = (int) Math.sqrt(n1 + n2);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int size = Integer.parseInt(bufferedReader.readLine());
            if (size <= n3) {
                stringBuilder.append("DA" + "\n");
            } else {
                stringBuilder.append("NE" + "\n");
            }
        }
        System.out.println(stringBuilder);
    }
}
