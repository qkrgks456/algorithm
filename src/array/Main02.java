package array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main02 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String input1 = bufferedReader.readLine();
        String input2 = bufferedReader.readLine();
        ArrayList<Integer> list = new ArrayList<>();
        String[] strings = input2.split(" ");
        for (String s : strings) {
            list.add(Integer.parseInt(s));
        }
        int max = list.get(0);
        int result = 1;
        for (int i = 1; i < list.size(); i++) {
            if (max < list.get(i)) {
                max = list.get(i);
                result++;
            }
        }
        System.out.println(result);
    }
}
