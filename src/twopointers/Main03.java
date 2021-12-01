package twopointers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main03 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input1 = bufferedReader.readLine();
        String[] inputArr1 = input1.split(" ");
        String input2 = bufferedReader.readLine();
        String[] inputArr2 = input2.split(" ");
        int arrCount = Integer.parseInt(inputArr1[0]);
        int num = Integer.parseInt(inputArr1[1]);
        int[] intList = new int[arrCount];
        for (int i = 0; i < inputArr2.length; i++) {
            intList[i] = Integer.parseInt(inputArr2[i]);
        }
        int start = 1;
        int end = intList.length - 1;
        int max = 0;
        int plus1 = 0;
        int plus2 = 0;
        for (int i = 0; i < num; i++) {
            plus1 += intList[i];
        }
        for (int j = end; j > end - num; j--) {
            plus2 += intList[j];
        }
        if (plus1 < plus2) {
            max = plus2;
        } else {
            max = plus1;
        }
        while (start + 1 <= end) {
            plus1 = 0;
            plus2 = 0;
            for (int i = start; i < num + start; i++) {
                plus1 += intList[i];
            }
            if (max < plus1) {
                max = plus1;
            }
            start++;
            for (int j = end - 1; j >= end - num; j--) {
                plus2 += intList[j];
            }
            if (max < plus2) {
                max = plus2;
            }
            end--;
        }
        System.out.println(max);
    }
}
