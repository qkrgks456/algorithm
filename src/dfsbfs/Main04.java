package dfsbfs;

import java.util.Scanner;

public class Main04 {
    static int[] ints;

    // 이거는 피보나치 재귀는 정말 어렵다 미친것 같다
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        ints = new int[num + 1];
        test(num);
        for (int i = 1; i <= num; i++) {
            System.out.print(ints[i] + " ");
        }
    }

    public static int test(int num) {
        if (num == 1) {
            return ints[num] = 1;
        } else if (num == 2) {
            return ints[num] = 1;
        } else {
            return ints[num] = test(num - 2) + test(num - 1);
        }
    }
}
