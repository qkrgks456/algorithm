package sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main03 {
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
        int n = 1;
        while (n < ints.length) {
            if (ints[n] < ints[n - 1]) {
                int bowl = ints[n - 1];
                ints[n - 1] = ints[n];
                ints[n] = bowl;
                if (n == 1) {
                    n++;
                } else {
                    n--;
                }
            } else {
                n++;
            }
        }
        for (int nums : ints) {
            System.out.print(nums + " ");
        }
    }
}
