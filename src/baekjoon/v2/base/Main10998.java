package baekjoon.v2.base;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10998 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        System.out.println((double) n / (double) m);
    }
}
