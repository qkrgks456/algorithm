package mylove.studymylove2;

import java.util.Scanner;

public class Main03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        System.out.println(gcb(1029, 1071 % 1029));
        System.out.println(gcb(3, 12 % 3));

    }

    public static int gcb(int num1, int num2) {
        if (num2 == 0) return num1;
        return gcb(num2, num1 % 3);
    }

}

