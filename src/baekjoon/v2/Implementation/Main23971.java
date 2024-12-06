package baekjoon.v2.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main23971 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int wCount = 1;
        if (w >= m) {
            wCount = w / (m + 1);
            if (w % (m + 1) > 0) wCount++;
        }
        int hCount = 1;
        if (h >= n) {
            hCount = h / (n + 1);
            if (h % (n + 1) > 0) hCount++;
        }
        System.out.println(wCount * hCount);


    }
}
