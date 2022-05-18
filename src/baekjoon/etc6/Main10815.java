package baekjoon.etc6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main10815 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        int N = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            map.put(Integer.parseInt(stringTokenizer.nextToken()), 1);
        }
        int M = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) {
            if (map.get(Integer.parseInt(stringTokenizer.nextToken())) == null) {
                stringBuilder.append(0 + " ");
            } else {
                stringBuilder.append(1 + " ");
            }
        }
        System.out.println(stringBuilder);
    }
}
