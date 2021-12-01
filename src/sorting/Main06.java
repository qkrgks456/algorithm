package sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main06 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        int n = Integer.parseInt(str);
        int[] ints = new int[n];
        String str2 = bufferedReader.readLine();
        String[] strings = str2.split(" ");
        for (int i = 0; i < strings.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        int lt = 0;
        int rt = 0;
        int maxIndex = 0;
        int min = ints[0];
        while (lt < ints.length) {
            if (min >= ints[rt]) {
                min = ints[rt];
                if (maxIndex < rt) {
                    maxIndex = rt;
                }
            }
            if (rt == ints.length - 1) {
                if (min < ints[lt]) {
                    System.out.println((lt + 1) + " " + (maxIndex + 1));
                    break;
                }
                lt++;
                min = ints[lt];
                rt = lt;
            } else {
                rt++;
            }
        }
    }
}
