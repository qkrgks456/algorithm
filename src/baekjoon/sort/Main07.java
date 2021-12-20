package baekjoon.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main07 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = bufferedReader.readLine();
        }
    }
}
