package baekjoon.v2.bruteforce;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main19532 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int x1 = Integer.parseInt(stringTokenizer.nextToken());
        int y1 = Integer.parseInt(stringTokenizer.nextToken());
        int n1 = Integer.parseInt(stringTokenizer.nextToken());
        int x2 = Integer.parseInt(stringTokenizer.nextToken());
        int y2 = Integer.parseInt(stringTokenizer.nextToken());
        int n2 = Integer.parseInt(stringTokenizer.nextToken());

        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                if ((x1 * x) + (y1 * y) == n1 && (x2 * x) + (y2 * y) == n2) {
                    System.out.println(x + " " + y);
                    break;
                }
            }
        }

    }
}
