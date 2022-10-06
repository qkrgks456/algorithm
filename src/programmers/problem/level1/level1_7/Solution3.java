package programmers.problem.level1.level1_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution3 {
    public String solution(String X, String Y) {
        List<Integer> list = new ArrayList<>();
        int[] ints = new int[3000001];
        for (String string : X.split("")) {
            ints[Integer.parseInt(string)]++;
        }
        int[] ints2 = new int[3000001];
        for (String string : Y.split("")) {
            ints2[Integer.parseInt(string)]++;
        }
        for (int i = 0; i < 3000001; i++) {
            if (ints[i] != 0 && ints2[i] != 0) {
                int min = Math.min(ints[i], ints2[i]);
                for (int j = 0; j < min; j++) {
                    list.add(i);
                }
            }
        }
        if (list.size() == 0) return "-1";
        Collections.sort(list, Collections.reverseOrder());
        String str = list.toString().replaceAll("[^0-9]", "");
        if (str.split("")[0].equals("0")) return "0";
        return str;
    }
}
