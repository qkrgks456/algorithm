package baekjoon.etc5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main17219 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            String site = stringTokenizer.nextToken();
            String pass = stringTokenizer.nextToken();
            map.put(site, pass);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String site = bufferedReader.readLine();
            stringBuilder.append(map.get(site) + "\n");
        }
        System.out.println(stringBuilder);
    }
}
