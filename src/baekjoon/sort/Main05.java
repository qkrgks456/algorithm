package baekjoon.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main05 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String[] strings = s.split("");
        int[] ints = new int[strings.length];
        int[] ch = new int[10];
        int[] result = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        for (int n : ints) {
            ch[n]++;
        }
        for (int i = 0; i < ch.length - 1; i++) {
            ch[i + 1] = ch[i] + ch[i + 1];
        }
        // 0 1 2 3 4
        for (int i = ints.length - 1; i >= 0; i--) {
            result[ch[ints[i]] - 1] = ints[i];
            ch[ints[i]]--;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = result.length - 1; i >= 0; i--) {
            stringBuilder.append(result[i]);
        }
        System.out.println(stringBuilder);
    }
}
