package baekjoon.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main06 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        ArrayList<Integer> list1 = null;
        for (int i = 0; i < n; i++) {
            String s = bufferedReader.readLine();
            String[] strings = s.split(" ");
            for (int j = 0; j < 2; j++) {
                list1 = new ArrayList<>();
                list1.add(Integer.parseInt(strings[j]));
            }
            list.add(list1);
        }
        int lt = 0;
        while (true) {

            list.get(lt).get(0);
        }
    }
}
