package baekjoon.v1.etc11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1753 {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        List<List<Edge>> list = new ArrayList<>();
        int V = Integer.parseInt(stringTokenizer.nextToken());
        int E = Integer.parseInt(stringTokenizer.nextToken());
        int start = Integer.parseInt(bufferedReader.readLine());
        // 1. 인접 리스트 생성
        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }
        // 2. 인접 리스트 넣기
        for (int i = 0; i < E; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int u = Integer.parseInt(stringTokenizer.nextToken());
            int v = Integer.parseInt(stringTokenizer.nextToken());
            int w = Integer.parseInt(stringTokenizer.nextToken());
            list.get(u).add(new Edge(v, w));
        }
        // 3. dis 배열 모두 MAX로 채우기
        int[] dis = new int[V + 1];
        for (int i = 1; i < V + 1; i++) {
            if (i == start) continue;
            dis[i] = Integer.MAX_VALUE;
        }
        // 4. 우선순위큐에 시작정점 넣기
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(start, 0));
        // 5. 다익스트라
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            int now = edge.vex;
            int nowCost = edge.cost;
            if (nowCost > dis[now]) continue;
            for (Edge eg : list.get(now)) {
                if (dis[eg.vex] > eg.cost + nowCost) {
                    dis[eg.vex] = eg.cost + nowCost;
                    priorityQueue.add(new Edge(eg.vex, eg.cost + nowCost));
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < dis.length; i++) {
            if (dis[i] == Integer.MAX_VALUE) {
                stringBuilder.append("INF\n");
                continue;
            }
            stringBuilder.append(dis[i]).append("\n");
        }
        System.out.println(stringBuilder);
    }
}

class Edge implements Comparable<Edge> {

    int vex;
    int cost;

    public Edge(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
