package baekjoon.step.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main07 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(bufferedReader.readLine());
        }
        String[] strings = set.toArray(new String[0]);
        int num = 0;
        while (num < strings.length - 1) {
            if (strings[num].length() > strings[num + 1].length()) {
                String s = strings[num];
                strings[num] = strings[num + 1];
                strings[num + 1] = s;
                if (num < 1) {
                    num++;
                } else {
                    num--;
                }
            } else if (strings[num].length() == strings[num + 1].length()) {
                if (strings[num].compareTo(strings[num + 1]) > 0) {
                    String s1 = strings[num];
                    strings[num] = strings[num + 1];
                    strings[num + 1] = s1;
                    if (num < 1) {
                        num++;
                    } else {
                        num--;
                    }
                } else {
                    num++;
                }
            } else {
                num++;
            }
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String s : strings) {
            bufferedWriter.write(s);
            bufferedWriter.write("\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
