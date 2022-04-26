package baekjoon.etc4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1259 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            String s = bufferedReader.readLine();
            int n = Integer.parseInt(s);
            if (n == 0) {
                break;
            }
            String check = "";
            for (int i = s.length() - 1; i >= 0; i--) {
                check += s.charAt(i);
            }
            if (n == Integer.parseInt(check)) {
                stringBuilder.append("yes\n");
            } else {
                stringBuilder.append("no\n");
            }
        }
        System.out.println(stringBuilder);
    }
}
