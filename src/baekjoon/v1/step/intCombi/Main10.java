package baekjoon.v1.step.intCombi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main10 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        if (n == 0) {
            System.out.println(0);
        }
        for (int i = 0; i < n; i++) {
            int n1 = Integer.parseInt(bufferedReader.readLine());
            HashMap<String, Integer> map = new HashMap<>();
            for (int j = 0; j < n1; j++) {
                String s = bufferedReader.readLine();
                String[] strings = s.split(" ");
                if (map.containsKey(strings[1])) {
                    map.put(strings[1], map.get(strings[1]) + 1);
                } else {
                    map.put(strings[1], 1);
                }
            }
            int sum = 1;
            for (String s : map.keySet()) {
                sum *= map.get(s) + 1;
            }
            System.out.println(sum - 1);
        }
    }
}
