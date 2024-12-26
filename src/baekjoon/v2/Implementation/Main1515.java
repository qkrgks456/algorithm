package baekjoon.v2.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1515 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] split = s.split("");
        int index = 1;
        int strIdx = 0;
        while (true) {
            String check = String.valueOf(index);
            String[] ch = check.split("");
            for (String string : ch) {
                if (strIdx == s.length()) break;
                if (string.equals(split[strIdx])) strIdx++;
            }
            if (strIdx == s.length()) break;
            index++;
        }

        System.out.println(index);
    }
}
