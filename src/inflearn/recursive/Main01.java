package inflearn.recursive;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main01 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = bufferedReader.readLine();
        int num = Integer.parseInt(str1);
        String str2 = bufferedReader.readLine();
        String[] strings = str2.split(" ");
        int[] ints = new int[num];
        for (int i = 0; i < str2.length(); i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }

    }
}
