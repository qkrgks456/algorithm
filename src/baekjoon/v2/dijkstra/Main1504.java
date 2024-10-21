package baekjoon.v2.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1504 {
    static int n, e;
    static List<List<Edge>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        n = Integer.parseInt(stringTokenizer.nextToken());
        e = Integer.parseInt(stringTokenizer.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            list.get(a).add(new Edge(b, c));
            list.get(b).add(new Edge(a, c));
        }
        // 이 두 정점은 반드시 방문하는 최단거리 ..
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int v1 = Integer.parseInt(stringTokenizer.nextToken());
        int v2 = Integer.parseInt(stringTokenizer.nextToken());

        // 1에서 v1 최단거리 + v1에서 v2 최단거리 + v2에서 N 최단거리
        int s1 = fastLoad(1, v1);
        int s2 = fastLoad(v1, v2);
        int s3 = fastLoad(v2, n);
        int result1 = Integer.MAX_VALUE;
        if (s1 != -1 && s2 != -1 && s3 != -1) {
            result1 = s1 + s2 + s3;
        }
        // 1에서 v2 최단거리 + v2에서 v1 최단거리 + v1에서 N 최단거리
        int s4 = fastLoad(1, v2);
        int s5 = fastLoad(v2, v1);
        int s6 = fastLoad(v1, n);
        int result2 = Integer.MAX_VALUE;
        if (s4 != -1 && s5 != -1 && s6 != -1) {
            result2 = s4 + s5 + s6;
        }

        if (result1 == Integer.MAX_VALUE && result2 == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(result1, result2));
        }

    }

    public static int fastLoad(int start, int end) {
        int[] dis = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[start] = 0;
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(start, 0));
        while (!priorityQueue.isEmpty()) {
            Edge eg = priorityQueue.poll();
            int nowCost = eg.cost;
            int nowVertex = eg.vertex;
            if (nowVertex == end) break;
            for (Edge edge : list.get(nowVertex)) {
                if (dis[edge.vertex] > nowCost + edge.cost) {
                    dis[edge.vertex] = nowCost + edge.cost;
                    priorityQueue.add(new Edge(edge.vertex, nowCost + edge.cost));
                }
            }
        }
        return dis[end] == Integer.MAX_VALUE ? -1 : dis[end];
    }

    static class Edge implements Comparable<Edge> {
        int vertex;
        int cost;

        public Edge(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}
