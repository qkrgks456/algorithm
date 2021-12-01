package twopointers;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main04 {
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

        int result = 0;
        for (int i = 0; i < intList.length; i++) {
            int plus = 0;
            for (int j = i; j < intList.length; j++) {
                plus += intList[j];
                if (plus == num) {
                    result++;
                    break;
                } else if (plus > num) {
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
