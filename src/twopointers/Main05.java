package twopointers;

import java.util.Scanner;

public class Main05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int result = 0;
        for (int i = 0; i < num; i++) {
            if ((i + 1) * 2 >= num) {
                break;
            }
            int plus = 0;
            for (int j = i; j < num; j++) {
                plus += j + 1;
                if (plus == num) {
                    result++;
                    break;
                } else if (plus > num) {
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
