package baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main1764 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = bufferedReader.readLine().split(" ");
        Map<String, Integer> map = new HashMap();
        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(strings[0]);
        int m = Integer.parseInt(strings[1]);
        for (int i = 0; i < n; i++) {
            String s = bufferedReader.readLine();
            map.put(s, 1);
        }
        for (int i = 0; i < m; i++) {
            String s = bufferedReader.readLine();
            if (map.get(s) != null) {
                if (map.get(s) == 1) {
                    list.add(s);
                }
            }
        }
        Collections.sort(list);
        stringBuilder.append(list.size() + "\n");
        for (String s : list) {
            stringBuilder.append(s + "\n");
        }
        System.out.println(stringBuilder);
    }
}
