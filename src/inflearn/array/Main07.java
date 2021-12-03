package inflearn.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main07 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input1 = bufferedReader.readLine();
        String input2 = bufferedReader.readLine();
        String[] strings = input2.split(" ");
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (String s : strings) {
            list.add(Integer.parseInt(s));
        }
        int num = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) >= 1) {
                if (num == 1) {
                    int before = result.get(i - 1);
                    before++;
                    result.add(before);
                } else {
                    result.add(1);
                }
                num = 1;
            } else {
                num = 0;
                result.add(0);
            }
        }
        int count = 0;
        for (int resultNum : result) {
            count += resultNum;
        }
        System.out.println(count);
    }
}
