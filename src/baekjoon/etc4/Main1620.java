package baekjoon.etc4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main1620 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n1 = Integer.parseInt(stringTokenizer.nextToken());
        int n2 = Integer.parseInt(stringTokenizer.nextToken());
        Map<Integer, String> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 1; i <= n1; i++) {
            String s = bufferedReader.readLine();
            map.put(i, s);
            map2.put(s, i);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n2; i++) {
            String s = bufferedReader.readLine();
            if (numCheck(s)) {
                stringBuilder.append(map.get(Integer.parseInt(s)) + "\n");
            } else {
                stringBuilder.append(map2.get(s) + "\n");
            }
        }
        System.out.println(stringBuilder);
    }

    public static boolean numCheck(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
