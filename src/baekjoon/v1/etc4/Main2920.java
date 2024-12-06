package baekjoon.v1.etc4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2920 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int[] ints = new int[9];
        for (int i = 1; i < ints.length; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        if (ints[1] == 1) {
            boolean check = true;
            for (int i = 2; i < ints.length; i++) {
                if (ints[i] != i) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.println("ascending");
            } else {
                System.out.println("mixed");
            }
        } else if (ints[1] == 8) {
            boolean check = true;
            for (int i = 2; i < ints.length; i++) {
                if (ints[i] != ints.length - i) {
                    check = false;
                    break;
                }
            }
            if (check) {
                System.out.println("descending");
            } else {
                System.out.println("mixed");
            }
        } else {
            System.out.println("mixed");
        }
    }
}
