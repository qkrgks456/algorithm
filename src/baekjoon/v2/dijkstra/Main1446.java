package baekjoon.v2.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main1446 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int d = Integer.parseInt(stringTokenizer.nextToken());
        List<List<Edge>> list = new ArrayList<>();
        for (int i = 0; i < d; i++) {
            list.add(new ArrayList<>());
            list.get(i).add(new Edge(i + 1, 1));
        }

        for (int i = 0; i < n; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int a = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            int c = Integer.parseInt(stringTokenizer.nextToken());
            if (a > d || b > d) continue;
            list.get(a).add(new Edge(b, c));
        }
        int[] dis = new int[d + 1];
        for (int i = 1; i <= d; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(0, 0));
        while (!priorityQueue.isEmpty()) {
            Edge eg = priorityQueue.poll();
            int nowVertex = eg.vertex;
            int nowCost = eg.cost;
            if (nowVertex == d) break;
            for (Edge edge : list.get(nowVertex)) {
                if (dis[edge.vertex] > nowCost + edge.cost) {
                    dis[edge.vertex] = nowCost + edge.cost;
                    priorityQueue.add(new Edge(edge.vertex, nowCost + edge.cost));
                }
            }
        }
        System.out.println(dis[d]);
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
