package baekjoon.step.greedy;

import java.util.Scanner;

public class Main04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s = scanner.nextLine();
        String[] strings = s.split("-");
        int[] result = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            String[] strings1 = strings[i].split("\\+");
            int sum = 0;
            for (String str : strings1) {
                sum += Integer.parseInt(str);
            }
            result[i] = sum;
        }
        int num = result[0];
        for (int i = 1; i < result.length; i++) {
            num -= result[i];
        }
        System.out.println(num);
    }
}
