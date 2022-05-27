package mylove.studymylove;

import java.util.Scanner;

public class Test13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int n1 = num / 10;
        int n2 = num % 10;
        int count = 0;
        while (true) {
            count++;
            int check = n1 + n2;
            int result = n2 * 10 + check % 10;
            n1 = result / 10;
            n2 = result % 10;
            if (result == num) {
                break;
            }
        }
        System.out.println(count);
    }
}
