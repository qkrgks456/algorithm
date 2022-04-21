package baekjoon.step.priorityQueue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main04 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> maxQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        int n = Integer.parseInt(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        // 나의 생각은 리스트로 보관하는건데 당연히 시간초과 뜰것 같았다 ..
        // 큐 2개 쓰는거 미쳤다 상상도 못했네
        // 이걸 어떻게 해내는 것인가 말이 되나
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(bufferedReader.readLine());
            if (maxQueue.size() == minQueue.size()) {
                maxQueue.add(num);
            } else {
                minQueue.add(num);
            }
            if (!maxQueue.isEmpty() && !minQueue.isEmpty() && maxQueue.peek() > minQueue.peek()) {
                int check = maxQueue.poll();
                maxQueue.add(minQueue.poll());
                minQueue.add(check);
            }
            stringBuilder.append(maxQueue.peek() + "\n");
        }
        System.out.println(stringBuilder);
    }
}
