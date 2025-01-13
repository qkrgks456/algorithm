package baekjoon.v2.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main2607 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String word1 = br.readLine();
        int result = 0;
        for (int i = 0; i < n - 1; i++) {
            String word2 = br.readLine();
            if (sameCheck(word1, word2)) result++;
        }
        System.out.println(result);
    }

    // 단어 췤
    public static boolean sameCheck(String word1, String word2) {
        // 길이 차이가 2 이상이면 비슷한 단어가 될 수 없음
        if (Math.abs(word1.length() - word2.length()) > 1) return false;

        String[] strings1 = word1.split("");
        Map<String, Integer> map1 = new HashMap<>();
        for (String s : strings1) {
            map1.put(s, map1.getOrDefault(s, 0) + 1);
        }
        String[] strings2 = word2.split("");
        Map<String, Integer> map2 = new HashMap<>();
        for (String s : strings2) {
            map2.put(s, map2.getOrDefault(s, 0) + 1);
        }

        // 빈도수 차이 계산
        int difference = 0;
        for (String s : map1.keySet()) {
            int count1 = map1.getOrDefault(s, 0);
            int count2 = map2.getOrDefault(s, 0);
            difference += Math.abs(count1 - count2);
        }

        for (String s : map2.keySet()) {
            if (!map1.containsKey(s)) {
                difference += map2.get(s); // map1에 없는 문자 추가
            }
        }


        // 길이가 같은 경우: 차이의 합이 2 이하
        if (word1.length() == word2.length()) {
            return difference <= 2;
        }
        // 길이가 다른 경우: 차이의 합이 1
        else {
            return difference == 1;
        }


    }

}
