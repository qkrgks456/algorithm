package twopointers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main01 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input1 = bufferedReader.readLine();
        String input2 = bufferedReader.readLine();
        String[] inputArr1 = input2.split(" ");
        String input3 = bufferedReader.readLine();
        String input4 = bufferedReader.readLine();
        String[] inputArr2 = input4.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < inputArr1.length; i++) {
            list.add(Integer.parseInt(inputArr1[i]));
        }
        for (int i = 0; i < inputArr2.length; i++) {
            list.add(Integer.parseInt(inputArr2[i]));
        }
        Collections.sort(list);
        for (int n : list) {
            System.out.print(n + " ");
        }
    }
}
