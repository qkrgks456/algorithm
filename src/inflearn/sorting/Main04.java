package inflearn.sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main04 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        String[] strings = s.split(" ");
        int n = Integer.parseInt(strings[0]);
        int arrNum = Integer.parseInt(strings[1]);
        String s1 = bufferedReader.readLine();
        String[] strings1 = s1.split(" ");
        int[] ints = new int[arrNum];
        int[] result = new int[n];
        for (int i = 0; i < strings1.length; i++) {
            ints[i] = Integer.parseInt(strings1[i]);
        }


        result[0] = ints[0];
        int changeNum = 0;
        for (int i = 1; i < ints.length; i++) {
            boolean check = false;
            for (int j = 0; j < result.length; j++) {
                if (ints[i] == result[j]) {
                    changeNum = j;
                    check = true;
                    break;
                }
            }
            if (check) {
                while (changeNum != 0) {
                    int num = result[changeNum - 1];
                    result[changeNum - 1] = result[changeNum];
                    result[changeNum] = num;
                    changeNum--;
                }
            } else {
                int index = result.length - 1;
                if (result[result.length - 1] == 0) {
                    while (index >= 0) {
                        if (result[index] != 0) {
                            result[index + 1] = result[index];
                        }
                        index--;
                    }
                } else {
                    while (index > 0) {
                        result[index] = result[index - 1];
                        index--;
                    }
                }
                result[0] = ints[i];
            }
        }
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
