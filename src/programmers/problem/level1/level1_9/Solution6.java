package programmers.problem.level1.level1_9;

import java.util.PriorityQueue;

public class Solution6 {

    public int[] solution(int k, int[] score) {
        int[] result = new int[score.length];
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < score.length; i++) {
            if (priorityQueue.size() != k) {
                priorityQueue.add(score[i]);
                result[i] = priorityQueue.peek();
                continue;
            }
            if (score[i] > priorityQueue.peek()) {
                priorityQueue.poll();
                priorityQueue.add(score[i]);
                result[i] = priorityQueue.peek();
                continue;
            }
            result[i] = priorityQueue.peek();
        }
        return result;
    }
}
