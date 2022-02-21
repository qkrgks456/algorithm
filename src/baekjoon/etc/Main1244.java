package baekjoon.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main1244 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] ints = new int[n];
        String[] strings = bufferedReader.readLine().split(" ");
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        int n1 = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n1; i++) {
            String[] strings1 = bufferedReader.readLine().split(" ");
            int mail = Integer.parseInt(strings1[0]);
            int number = Integer.parseInt(strings1[1]);
            if (mail == 1) {
                for (int j = number; j < ints.length; j += number) {
                    if (ints[j] == 1) {
                        ints[j] = 0;
                    } else {
                        ints[j] = 1;
                    }
                }
            } else {
                if (ints[number] == 1) {
                    ints[number] = 0;
                } else {
                    ints[number] = 1;
                }
                int lt = number - 1;
                int rt = number + 1;
                while (lt > 0 && rt < ints.length) {
                    if (ints[lt] != ints[rt]) {
                        break;
                    }
                    if (ints[lt] == 1) {
                        ints[lt] = 0;
                    } else {
                        ints[lt] = 1;
                    }
                    if (ints[rt] == 1) {
                        ints[rt] = 0;
                    } else {
                        ints[rt] = 1;
                    }
                    lt--;
                    rt++;
                }
            }
            for (int j = 0; j < ints.length; j++) {
                System.out.print(ints[i] + " ");
            }
        }

    }
}
