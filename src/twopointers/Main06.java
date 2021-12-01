package twopointers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main06 {
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
        int max = 0;
        int count = 0;
        int rt = 0;
        int lt = 0;
        for (rt = 0; rt < intList.length; rt++) {
            if (intList[rt] == 0) {
                count++;
            }
            while (count > num) {
                if (intList[lt] == 0) {
                    count--;
                }
                lt++;
            }
            if (max < rt - lt + 1) {
                max = rt - lt + 1;
            }
        }
        System.out.println(max);
    }
}
