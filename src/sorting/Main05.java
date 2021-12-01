package sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main05 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        int n = Integer.parseInt(str);
        String str2 = bufferedReader.readLine();
        String[] strings = str2.split(" ");
        int[] ints = new int[n];
        for (int i = 0; i < strings.length; i++) {
            ints[i] = Integer.parseInt(strings[i]);
        }
        int rt = 1;
        boolean check = false;
        while (rt < ints.length) {
            if (rt > 1) {
                if (ints[rt - 1] > ints[rt]) {
                    int num = ints[rt - 1];
                    ints[rt - 1] = ints[rt];
                    ints[rt] = num;
                    rt--;
                } else if (ints[rt - 1] == ints[rt]) {
                    check = true;
                    break;
                } else {
                    rt++;
                }
            } else {
                rt++;
            }
        }
        if (check) {
            System.out.println("D");
        } else {
            System.out.println("U");
        }
    }
}
