package programmers.problem.level2.level2_10;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution2 {

    public int solution(int N, int[][] road, int K) {
        List<List<Edge>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < road.length; i++) {
            list.get(road[i][0]).add(new Edge(road[i][1], road[i][2]));
            list.get(road[i][1]).add(new Edge(road[i][0], road[i][2]));
        }
        int[] dis = new int[N + 1];
        for (int i = 2; i < dis.length; i++) {
            dis[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Edge(1, 0));
        while (!priorityQueue.isEmpty()) {
            Edge edge = priorityQueue.poll();
            int now = edge.vex;
            int nowCost = edge.cost;
            if (dis[now] < nowCost) continue;
            for (Edge eg : list.get(now)) {
                if (dis[eg.vex] > eg.cost + nowCost) {
                    dis[eg.vex] = eg.cost + nowCost;
                    priorityQueue.add(new Edge(eg.vex, eg.cost + nowCost));
                }
            }
        }
        int answer = 0;
        for (int i = 1; i < dis.length; i++) {
            if (K >= dis[i]) answer++;
        }
        return answer;
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