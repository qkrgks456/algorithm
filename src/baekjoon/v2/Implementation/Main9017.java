package baekjoon.v2.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main9017 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] ints = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            Map<Integer, Integer> countMap = new HashMap<>();
            for (int j = 0; j < n; j++) {
                ints[j] = Integer.parseInt(st.nextToken());
                countMap.put(ints[j], countMap.getOrDefault(ints[j], 0) + 1);
            }
            // 6이 아닌 애들 숫자 찾기
            List<Integer> check = new ArrayList<>();
            for (int num : countMap.keySet()) {
                if (countMap.get(num) != 6) check.add(num);
            }
            // 6이 아니면 0으로
            for (int j = 0; j < n; j++) {
                if (check.contains(ints[j])) ints[j] = 0;
            }

            // 4명까지 합
            int rank = 0;
            Map<Integer, Integer> sumMap = new HashMap<>();
            countMap = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (ints[j] == 0) continue;
                rank++;
                countMap.put(ints[j], countMap.getOrDefault(ints[j], 0) + 1);
                if (countMap.get(ints[j]) <= 4) {
                    sumMap.put(ints[j], sumMap.getOrDefault(ints[j], 0) + rank);
                }
            }
            // 최소값 구하기
            int result = Integer.MAX_VALUE;
            for (int num : sumMap.keySet()) {
                result = Math.min(sumMap.get(num), result);
            }
            // 최솟값 크기가 같은 녀석이 한개인지 두개인지
            int count = 0;
            List<Integer> minList = new ArrayList<>();
            for (int num : sumMap.keySet()) {
                if (sumMap.get(num) == result) {
                    minList.add(num);
                    count++;
                }
            }
            if (count > 1) {
                int res = 0;
                countMap = new HashMap<>();
                for (int j = 0; j < n; j++) {
                    if (!minList.contains(ints[j])) continue;
                    countMap.put(ints[j], countMap.getOrDefault(ints[j], 0) + 1);
                    if (countMap.get(ints[j]) > 4) {
                        res = ints[j];
                        break;
                    }
                }
                sb.append(res).append("\n");

            } else {
                sb.append(minList.get(0)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
