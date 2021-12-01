package sorting;

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
        for (int i = 0; i < strings.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        int lt = 0;
        int rt = 0;
        int index = 0;
        int min = ints[0];
        while (lt < ints.length - 1) {
            if (min >= ints[rt]) {
                min = ints[rt];
                index = rt;
            }
            if (rt == ints.length - 1) {
                ints[index] = ints[lt];
                ints[lt] = min;
                lt++;
                min = ints[lt];
                rt = lt;
            } else {
                rt++;
            }
        }
        for (int n : ints) {
            System.out.print(n + " ");
        }
    }
}
