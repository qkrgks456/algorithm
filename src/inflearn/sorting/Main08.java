package inflearn.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main08 {
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
        int index = 1;
        while (index < ints.length) {
            if (ints[index] < ints[index - 1]) {
                int num = ints[index];
                ints[index] = ints[index - 1];
                ints[index - 1] = num;
                if (index == 1) {
                    index++;
                } else {
                    index--;
                }
            } else {
                index++;
            }
        }
        int lt = 0;
        int rt = ints.length - 1;
        int mid = (rt - lt) / 2;
        while (true) {
            if (ints[mid] == n2) {
                mid++;
                System.out.println(mid);
                break;
            } else if (ints[mid] < n2) {
                lt = mid;
                mid = (rt + lt) / 2;
            } else {
                rt = mid;
                mid = mid / 2;
            }
        }
    }
}
