package inflearn.hashtree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main03 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input1 = bufferedReader.readLine();
        String[] inputArr1 = input1.split(" ");
        String input2 = bufferedReader.readLine();
        String[] inputArr2 = input2.split(" ");
        int arrCount = Integer.parseInt(inputArr1[0]);
        int num = Integer.parseInt(inputArr1[1]);
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int[] intList = new int[arrCount];
        for (int i = 0; i < inputArr2.length; i++) {
            intList[i] = Integer.parseInt(inputArr2[i]);
        }
        int rt = 0;
        int lt = 0;
        while (rt < intList.length) {
            if (lt + num == rt) {
                int leftMinus = map.get(intList[lt]);
                leftMinus--;
                if (leftMinus == 0) {
                    map.remove(intList[lt]);
                } else {
                    map.put(intList[lt], leftMinus);
                }
                lt++;
            } else {
                list.clear();
            }
            if (map.containsKey(intList[rt])) {
                int RightPlus = map.get(intList[rt]);
                RightPlus++;
                map.put(intList[rt], RightPlus);
            } else {
                map.put(intList[rt], 1);
            }
            list.add(map.size());
            rt++;
        }
        for (int n : list) {
            System.out.print(n + " ");
        }
    }
}
