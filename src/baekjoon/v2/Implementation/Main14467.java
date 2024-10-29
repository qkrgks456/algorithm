package baekjoon.v2.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main14467 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int num = Integer.parseInt(stringTokenizer.nextToken());
            int location = Integer.parseInt(stringTokenizer.nextToken());
            if (map.get(num) == null) {
                map.put(num, location);
            } else {
                if (map.get(num) != location) {
                    map.put(num, location);
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
