package baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1759 {
    static int l, c;
    static char[] result, chars;
    static int[] ch = new int[26];
    static int[] ch2 = new int[26];

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        l = Integer.parseInt(stringTokenizer.nextToken());
        c = Integer.parseInt(stringTokenizer.nextToken());
        result = new char[l];
        chars = new char[c];
        String[] strings = bufferedReader.readLine().split(" ");
        for (int i = 0; i < c; i++) {
            chars[i] = strings[i].charAt(0);
        }
        Arrays.sort(chars);
        recursion(0);
    }

    public static void recursion(int n) {
        if (n == l) {
            for (char c : result) {
                System.out.print(c);
            }
            System.out.println();
            return;
        }
        // +0 , +1, +2
        for (int i = n; i < c; i++) {
            if (ch[chars[i] - 97] == 0) {
                ch[chars[i] - 97] = 1;
                result[n] = chars[i];
                recursion(n + 1);
                ch[chars[i] - 97] = 0;
            }
        }
    }
}
