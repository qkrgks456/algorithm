package baekjoon.v2.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main18352 {


    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken()); // 정점
        int M = Integer.parseInt(stringTokenizer.nextToken()); // 간선
        int K = Integer.parseInt(stringTokenizer.nextToken());
        int X = Integer.parseInt(stringTokenizer.nextToken());
        int[] dist = new int[N + 1];
        List<List<Integer>> graph = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(X);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            dist[i] = -1;
        }
        for (int i = 0; i < M; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int start = Integer.parseInt(stringTokenizer.nextToken());
            int end = Integer.parseInt(stringTokenizer.nextToken());
            graph.get(start).add(end);
        }
        StringBuilder stringBuilder = new StringBuilder();
        dist[X] = 0;
        while (!queue.isEmpty()) {    // BFS 진행
            int now = queue.poll();
            if (dist[now] > K) break;    // 현재 거리가 K를 넘으면 종료
            if (dist[now] == K) stringBuilder.append(now).append("\n");    // 출발지점에서 거리가 K라면 결과 리스트에 추가
            for (int next : graph.get(now)) {    // 간선 순회
                if (dist[next] != -1) continue;    // 방문 체크
                dist[next] = dist[now] + 1;    // 다음 위치는 현재 지점의 거리+1
                queue.add(next);    // 다음 위치 진행
            }
        }
        if (stringBuilder.toString().isEmpty()) {
            System.out.println("-1");
            return;
        }
        System.out.println(stringBuilder);
    }

}
