package baekjoon.etc6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main11478 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> set = new HashSet<>();
        String s = bufferedReader.readLine();
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                set.add(s.substring(j, j + i + 1));
            }
        }
        System.out.println(set.size());
    }
}
