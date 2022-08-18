package baekjoon.etc10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3003 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        int num = Integer.parseInt(stringTokenizer.nextToken());
        stringBuilder.append((1 - num) + " ");
        num = Integer.parseInt(stringTokenizer.nextToken());
        stringBuilder.append((1 - num) + " ");
        num = Integer.parseInt(stringTokenizer.nextToken());
        stringBuilder.append((2 - num) + " ");
        num = Integer.parseInt(stringTokenizer.nextToken());
        stringBuilder.append((2 - num) + " ");
        num = Integer.parseInt(stringTokenizer.nextToken());
        stringBuilder.append((2 - num) + " ");
        num = Integer.parseInt(stringTokenizer.nextToken());
        stringBuilder.append(8 - num);
        System.out.println(stringBuilder);
    }
}
