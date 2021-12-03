package inflearn.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main03 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input1 = bufferedReader.readLine();
        String input2 = bufferedReader.readLine();
        String input3 = bufferedReader.readLine();
        String[] input2Arr = input2.split(" ");
        String[] input3Arr = input3.split(" ");
        ArrayList<Integer> firstList = new ArrayList<>();
        ArrayList<Integer> secondList = new ArrayList<>();
        for (String s : input2Arr) {
            firstList.add(Integer.parseInt(s));
        }
        for (String s : input3Arr) {
            secondList.add(Integer.parseInt(s));
        }
        int a = 0;
        int b = 0;
        for (int i = 0; i < firstList.size(); i++) {
            a = firstList.get(i);
            b = secondList.get(i);
            if (a == 1 && b == 2 || b == 1 && a == 2) {
                if (a > b) {
                    System.out.println("A");
                } else {
                    System.out.println("B");
                }
            } else if (a == 2 && b == 3 || b == 2 && a == 3) {
                if (a > b) {
                    System.out.println("A");
                } else {
                    System.out.println("B");
                }
            } else if (a == 1 && b == 3 || b == 1 && a == 3) {
                if (a < b) {
                    System.out.println("A");
                } else {
                    System.out.println("B");
                }
            } else {
                System.out.println("D");
            }
        }
    }
}
