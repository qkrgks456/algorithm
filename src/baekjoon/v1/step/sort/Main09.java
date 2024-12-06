package baekjoon.v1.step.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main09 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] ints1 = new int[n];
        String s = bufferedReader.readLine();
        String[] strings = s.split(" ");
        HashSet<Integer> set = new HashSet<>();
        // set으로 중복제거
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(strings[i]));
            ints1[i] = Integer.parseInt(strings[i]);
        }
        // 배열화
        Integer[] ints = set.toArray(new Integer[0]);
        // 정렬
        Arrays.sort(ints);
        HashMap<Integer, Integer> map = new HashMap<>();

        // 정렬 (오름차순)하면 인덱스가 걔보다 작은애들 갯수
        int ch = ints[0];
        int count = 0;
        map.put(ints[0], 0);
        for (int i = 1; i < ints.length; i++) {
            if (ch == ints[i]) {
                count++;
                map.put(ints[i], i - count);
            } else {
                count = 0;
                ch = ints[i];
                map.put(ints[i], i);
            }
        }

        // 출력
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int n2 : ints1) {
            bufferedWriter.write(map.get(n2) + " ");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
