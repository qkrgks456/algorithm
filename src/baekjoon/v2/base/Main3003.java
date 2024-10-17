package baekjoon.v2.base;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main3003 {
    public static void main(String[] args) throws Exception {
        int[] ints = {1, 1, 2, 2, 2, 8};
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int anInt : ints) {
            int n = Integer.parseInt(stringTokenizer.nextToken());
            System.out.print(anInt - n + " ");
        }
    }
}
