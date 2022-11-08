package programmers.problem.level2.level2_3;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class Solution9 {
    public int solution(int[] priorities, int location) {
        int result = 0;
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            if (i == location) {
                queue.add(new Point(priorities[i], 1));
            } else {
                queue.add(new Point(priorities[i], 0));
            }
        }
        while (!queue.isEmpty()) {
            Point first = queue.poll();
            int size = queue.size();
            boolean check = true;
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                if (first.x < point.x) {
                    check = false;
                }
                queue.add(point);
            }
            if (check) {
                result++;
                if (first.y == 1) break;
            } else {
                queue.add(first);
            }
        }
        return result;
    }
}
