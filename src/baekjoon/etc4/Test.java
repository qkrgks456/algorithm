package baekjoon.etc4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n1 = Integer.parseInt(stringTokenizer.nextToken());
            int n2 = Integer.parseInt(stringTokenizer.nextToken());
            stringBuilder.append("Case #" + (i + 1) + ": " + n1 + " + " + n2 + " = " + (n1 + n2) + "\n");
        }
        System.out.println(stringBuilder);
    }
}
