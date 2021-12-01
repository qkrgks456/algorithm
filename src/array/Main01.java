package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main01 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input1 = bufferedReader.readLine();
        String input2 = bufferedReader.readLine();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> resultList = new ArrayList<>();
        String[] numArr = input2.split(" ");
        for (String s : numArr) {
            list.add(Integer.parseInt(s));
        }
        resultList.add(list.get(0));
        int num1 = list.get(0);
        int num2 = 0;
        for (int i = 1; i < list.size(); i++) {
            num2 = list.get(i);
            if (num1 < num2) {
                resultList.add(num2);
            }
            num1 = num2;
        }
        for (int num : resultList) {
            System.out.print(num + " ");
        }
    }
}
