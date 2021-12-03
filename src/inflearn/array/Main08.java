package inflearn.array;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main08 {
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
        for (int i = 0; i < list.size(); i++) {
            int count = 1;
            for (int j = 0; j < list.size(); j++) {
                if (j != i) {
                    if (list.get(i) < list.get(j)) {
                        count++;
                    }
                }
            }
            result.add(count);
        }
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
