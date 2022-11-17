package programmers.problem.level2.level2_6;

import java.util.LinkedList;
import java.util.Queue;

public class Solution3 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> trucks = new LinkedList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int truck_weight : truck_weights) {
            trucks.add(truck_weight);
        }
        for (int i = 0; i < bridge_length; i++) {
            queue.add(0);
        }

        int sum = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            sum -= queue.peek();
            queue.poll();
            if (trucks.isEmpty()) {
                result += bridge_length;
                break;
            } else {
                if (sum + trucks.peek() <= weight) {
                    int truck = trucks.poll();
                    sum += truck;
                    queue.add(truck);
                } else {
                    queue.add(0);
                }
            }
            result++;
        }
        return result;
    }
}

