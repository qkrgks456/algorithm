package inflearn.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main10 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str = bufferedReader.readLine();
        String[] strings = str.split(" ");
        int n1 = Integer.parseInt(strings[0]);
        int n2 = Integer.parseInt(strings[1]);
        int[] ints = new int[n1];
        String str2 = bufferedReader.readLine();
        String[] strings1 = str2.split(" ");
        for (int i = 0; i < strings1.length; i++) {
            ints[i] = Integer.parseInt(strings1[i]);
        }
        Arrays.sort(ints);
        int lt = 1;
        int rt = ints[ints.length - 1];
        int mid = (lt + rt) / 2;
        int result = 0;
        while (lt <= rt) {
            int count = 1;
            int ep = 1;
            for (int n : ints) {
                if (n - ep >= mid) {
                    count++;
                    ep = n;
                }
            }
            if (count < n2) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
                result = mid;
            }
            mid = (lt + rt) / 2;
        }
        System.out.println(result);
    }
}
