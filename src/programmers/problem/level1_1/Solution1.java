package programmers.problem.level1_1;

import java.util.*;

public class Solution1 {
    static int[] score = {0, 3, 2, 1, 0, 1, 2, 3};
    static String[] type = {"R", "T", "C", "F", "J", "M", "A", "N"};

    public String solution(String[] survey, int[] choices) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (String s : type) {
            map.put(s, 0);
        }
        for (int i = 0; i < survey.length; i++) {
            String[] strings = survey[i].split("");
            if (choices[i] <= 3) {
                int n = map.get(strings[0]);
                map.put(strings[0], n + score[choices[i]]);
            } else if (choices[i] > 4) {
                int n = map.get(strings[1]);
                map.put(strings[1], n + score[choices[i]]);
            }
        }
        int num = 1;
        String s1 = "";
        int num1 = 0;
        String result = "";
        for (String type : map.keySet()) {
            if (num % 2 == 0) {
                if (num1 < map.get(type)) {
                    result += type;
                } else {
                    result += s1;
                }
            } else {
                s1 = type;
                num1 = map.get(type);
            }
            num++;
        }
        return result;
    }
}
