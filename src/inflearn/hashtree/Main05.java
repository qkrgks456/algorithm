package inflearn.hashtree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main05 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = bufferedReader.readLine();
        String str2 = bufferedReader.readLine();
        String[] strings1 = str1.split(" ");
        int arrNum = Integer.parseInt(strings1[0]);
        int n = Integer.parseInt(strings1[1]);
        int[] ints = new int[arrNum];
        TreeSet<Integer> set = new TreeSet<>();
        String[] strings2 = str2.split(" ");
        for (int i = 0; i < ints.length; i++) {
            ints[i] = Integer.parseInt(strings2[i]);
        }

        int first = 0;
        while (first < ints.length - 2) {
            for (int i = first + 1; i < ints.length; i++) {
                for (int j = i + 1; j < ints.length; j++) {
                    int total = ints[first] + ints[i];
                    total += ints[j];
                    set.add(total);
                }
            }
            first++;
        }
        Object[] objects = set.toArray();
        if (objects.length - n < 0) {
            System.out.println(-1);
        } else {
            System.out.println(objects[objects.length - n]);
        }
    }
}
