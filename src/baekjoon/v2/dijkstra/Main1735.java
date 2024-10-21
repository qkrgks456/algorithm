package baekjoon.v2.dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1735 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int v = Integer.parseInt(stringTokenizer.nextToken());
        int e = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(bufferedReader.readLine());
        List<List<Edge>> list = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int t = Integer.parseInt(stringTokenizer.nextToken());
            int w = Integer.parseInt(stringTokenizer.nextToken());
            list.get(u).add(new Edge(t, w));
        }
        int[] dis = new int[v + 1];
        for (int i = 1; i <= v; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        dis[k] = 0;
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(k, 0));
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            int nowVertex = edge.vertex;
            int nowCost = edge.cost;

            // 이미 처리된 정점이라면 무시
            if (dis[nowVertex] < nowCost) continue;

            for (Edge eg : list.get(nowVertex)) {
                if (dis[eg.vertex] > eg.cost + nowCost) {
                    dis[eg.vertex] = eg.cost + nowCost;
                    priorityQueue.add(new Edge(eg.vertex, eg.cost + nowCost));
                }
            }
        }
        for (int i = 1; i <= v; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
                continue;
            }
            System.out.println(dis[i]);
        }
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
