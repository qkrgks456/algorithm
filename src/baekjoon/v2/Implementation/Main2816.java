package baekjoon.v2.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main2816 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = br.readLine();
        }

        int index = 0;
        StringBuilder sb = new StringBuilder();
        while (!strings[0].equals("KBS1")) {
            if (strings[index].equals("KBS1")) {
                String temp = strings[index];
                strings[index] = strings[index - 1];
                strings[index - 1] = temp;
                sb.append(4);
                index--;
            } else {
                index++;
                sb.append(1);
            }
        }
        while (!strings[1].equals("KBS2")) {
            if (strings[index].equals("KBS2")) {
                String temp = strings[index];
                strings[index] = strings[index - 1];
                strings[index - 1] = temp;
                sb.append(4);
                index--;
            } else {
                index++;
                sb.append(1);
            }
        }
        System.out.println(sb);
    }
}
