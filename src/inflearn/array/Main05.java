package inflearn.array;

import java.util.Scanner;

public class Main05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int[] ints = new int[input + 1];
        int result = 0;
        for (int i = 2; i <= input; i++) {
            if (ints[i] == 0) {
                result++;
                for (int j = i; j <= input; j = j + i) {
                    if (j % i == 0) {
                        ints[j] = 1;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
