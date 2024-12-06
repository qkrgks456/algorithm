package baekjoon.v1.etc5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main5525 {
    public static void main(String[] args) throws Exception {
        // 어려운데 ??
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());
        char[] chars = bufferedReader.readLine().toCharArray();
        int count = 0;
        int result = 0;
        for (int i = 1; i < M - 1; i++) {
            if (chars[i - 1] == 'I' && chars[i] == 'O' && chars[i + 1] == 'I') {
                count++;
                if (count == N) {
                    count--;
                    result++;
                }
                i++;
            } else {
                count = 0;
            }
        }
        System.out.println(result);
    }
}
