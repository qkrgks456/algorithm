package baekjoon.etc8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main20055 {
    // 큐로 바꿔서 하는것부터 생각해봅시다
    static int[] ints;
    static int result = 0;
    static List<Robot> list = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int k = Integer.parseInt(stringTokenizer.nextToken());
        int checkNum = n - 1;
        ints = new int[2 * n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < 2 * n; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        while (true) {
            // 1.
            // 회전
            rotation();
            for (int i = list.size() - 1; i >= 0; i--) {
                Robot robot = list.get(i);
                robot.location++;
                ints[robot.location]--;
                if (robot.location == checkNum) {
                    list.remove(i);
                }
            }

            // 2.
            // 가장 맨앞의 로봇 일단 갈지 말지 선택
            if (list.size() != 0) {
                Robot robot = list.get(list.size() - 1);
                if (robot.location + 1 == checkNum) {
                    list.remove(list.size() - 1);
                } else {
                    if (ints[robot.location + 1] >= 1) {
                        robot.location++;
                    }
                }
            }

            // 나머지 로봇 앞뒤 나눠서 뒤로봇이 안 움직이면 앞로봇도 아무것도 안함
            for (int i = list.size() - 2; i >= 0; i--) {
                Robot frontRobot = list.get(i);
                Robot backRobot = list.get(i + 1);
                if (frontRobot.location + 1 != backRobot.location) {
                    if (ints[frontRobot.location + 1] >= 1) {
                        frontRobot.location++;
                        ints[frontRobot.location + 1]--;
                    }
                }
            }

            // 3.
            if (ints[0] != 0) {
                list.add(0, new Robot(0));
                ints[0]--;
            }

            // 4.
            int count = 0;
            for (int num : ints) {
                if (num == 0) {
                    count++;
                }
            }
            if (count >= k) {
                System.out.println(result);
                break;
            }
            result++;
        }
    }

    public static void rotation() {
        int num = ints[ints.length - 1];
        for (int i = ints.length - 1; i > 0; i--) {
            ints[i] = ints[i - 1];
        }
        ints[0] = num;
    }
}

class Robot {
    int location;

    public Robot(int location) {
        this.location = location;
    }
}
