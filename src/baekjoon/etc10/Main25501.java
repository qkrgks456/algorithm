package baekjoon.etc10;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main25501 {
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String s = bufferedReader.readLine();
            count = 0;
            stringBuilder.append(DFS(s, 0, s.length() - 1) + " ");
            stringBuilder.append(count + "\n");
        }
        System.out.println(stringBuilder);
    }
    public static int DFS(String s, int l, int r) {
        count++;
        if (l >= r) {
            return 1;
        } else if (s.charAt(l) != s.charAt(r)) {
            return 0;
        } else {
            return DFS(s, l + 1, r - 1);
        }
    }
}
