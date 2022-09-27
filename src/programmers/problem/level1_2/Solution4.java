package programmers.problem.level1_2;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Solution4 {
    public String solution(int[] numbers, String hand) {
        String result = "";
        Map<Integer, Point> map = new HashMap<>();
        int num = 0;
        for (int i = 1; i < 9; i += 3) {
            map.put(i, new Point(num, 0));
            map.put(i + 1, new Point(num, 1));
            map.put(i + 2, new Point(num, 2));
            num++;
        }
        map.put(0, new Point(3, 1));
        Point left = new Point(3, 0);
        Point right = new Point(3, 2);
        for (int number : numbers) {
            Point end = map.get(number);
            switch (number) {
                case 1:
                case 4:
                case 7:
                    left.x = end.x;
                    left.y = end.y;
                    result += "L";
                    break;
                case 3:
                case 6:
                case 9:
                    right.x = end.x;
                    right.y = end.y;
                    result += "R";
                    break;
                default:
                    int leftDis = Math.abs(left.x - end.x) + Math.abs(left.y - end.y);
                    int rightDis = Math.abs(right.x - end.x) + Math.abs(right.y - end.y);
                    if (leftDis > rightDis) {
                        right.x = end.x;
                        right.y = end.y;
                        result += "R";
                    } else if (leftDis < rightDis) {
                        left.x = end.x;
                        left.y = end.y;
                        result += "L";
                    } else {
                        if (hand.equals("right")) {
                            right.x = end.x;
                            right.y = end.y;
                            result += "R";
                        } else {
                            left.x = end.x;
                            left.y = end.y;
                            result += "L";
                        }
                    }
            }
        }
        return result;
    }
}
