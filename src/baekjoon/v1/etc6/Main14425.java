package baekjoon.v1.etc6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main14425 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        Map<String, Integer> map = new HashMap<>();
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        for (int i = 0; i < N; i++) {
            String s = bufferedReader.readLine();
            map.put(s, 1);
        }
        int count = 0;
        for (int i = 0; i < M; i++) {
            String s = bufferedReader.readLine();
            if (map.get(s) != null) {
                count++;
            }
        }
        System.out.println(count);
    }
}
