package baekjoon.v2.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main3758 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int k = Integer.parseInt(stringTokenizer.nextToken());
            int id = Integer.parseInt(stringTokenizer.nextToken());
            int m = Integer.parseInt(stringTokenizer.nextToken());
            // 일단 각 팀별 점수 취합하고 등수를 매겨보자
            Map<Integer, int[]> map = new HashMap<>();
            Map<Integer, Integer> countMap = new HashMap<>();
            List<Integer> order = new ArrayList<>();
            for (int j = 0; j < m; j++) {
                stringTokenizer = new StringTokenizer(br.readLine());
                int I = Integer.parseInt(stringTokenizer.nextToken()); // 팀
                int J = Integer.parseInt(stringTokenizer.nextToken()); // 문제
                int S = Integer.parseInt(stringTokenizer.nextToken()); // 점수
                countMap.put(I, countMap.getOrDefault(I, 0) + 1);
                order.add(I);
                if (map.get(I) == null) {
                    int[] ints = new int[k + 1];
                    ints[J] = S;
                    map.put(I, ints);
                } else {
                    int[] ints = map.get(I);
                    if (ints[J] <= S) {
                        ints[J] = S;
                        map.put(I, ints);
                    }
                }
            }
            List<Kcpc> kcpcs = new ArrayList<>();
            for (Integer integer : map.keySet()) {
                int sum = Arrays.stream(map.get(integer))
                        .sum();
                Kcpc kcpc = new Kcpc();
                kcpc.id = integer;
                kcpc.solveCount = countMap.get(integer);
                kcpc.score = sum;
                for (int j = order.size() - 1; j >= 0; j--) {
                    if (integer.equals(order.get(j))) {
                        kcpc.lastIndex = j;
                        break;
                    }
                }
                kcpcs.add(kcpc);
            }
            Collections.sort(kcpcs);
            int result = 1;
            for (Kcpc kcpc : kcpcs) {
                if (kcpc.id == id) {
                    sb.append(result).append("\n");
                }
                result++;
            }
        }
        System.out.println(sb);
    }
}

class Kcpc implements Comparable<Kcpc> {
    int id;
    int solveCount;
    int lastIndex;
    int score;

    @Override
    public int compareTo(Kcpc o) {
        if (o.score == this.score) {
            if (o.solveCount > this.solveCount) return -1;
            if (o.solveCount == this.solveCount) {
                return this.lastIndex - o.lastIndex;
            }
        }
        return o.score - this.score;
    }

    @Override
    public String toString() {
        return "Kcpc{" +
                "id=" + id +
                ", solveCount=" + solveCount +
                ", lastIndex=" + lastIndex +
                ", score=" + score +
                '}';
    }
}
