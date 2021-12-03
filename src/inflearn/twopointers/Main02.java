package inflearn.twopointers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main02 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input1 = bufferedReader.readLine();
        String input2 = bufferedReader.readLine();
        String[] inputArr1 = input2.split(" ");
        String input3 = bufferedReader.readLine();
        String input4 = bufferedReader.readLine();
        String[] inputArr2 = input4.split(" ");
        int[] firstArr = new int[Integer.parseInt(input1)];
        int[] secondArr = new int[Integer.parseInt(input3)];
        for (int i = 0; i < Integer.parseInt(input1); i++) {
            firstArr[i] = Integer.parseInt(inputArr1[i]);
        }
        for (int i = 0; i < Integer.parseInt(input3); i++) {
            secondArr[i] = Integer.parseInt(inputArr2[i]);
        }
        Arrays.sort(firstArr);
        Arrays.sort(secondArr);
        ArrayList<Integer> list = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        while (p1 < Integer.parseInt(input1) && p2 < Integer.parseInt(input3)) {
            if (firstArr[p1] < secondArr[p2]) {
                p1++;
            } else if (firstArr[p1] == secondArr[p2]) {
                list.add(firstArr[p1]);
                p2++;
            } else {
                p2++;
            }
        }
        for (int n : list) {
            System.out.print(n + " ");
        }
    }
}
