package inflearn.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main02 {
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
        int rt = ints.length - 1;
        while (rt != 0) {
            if (lt == rt) {
                rt--;
                lt = 0;
            }
            if (ints[lt] > ints[lt + 1]) {
                int bowl = ints[lt + 1];
                ints[lt + 1] = ints[lt];
                ints[lt] = bowl;
            }
            lt++;
        }
        for (int n : ints) {
            System.out.print(n + " ");
        }
    }
}
