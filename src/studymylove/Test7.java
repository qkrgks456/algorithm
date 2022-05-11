package studymylove;

import java.util.Scanner;

public class Test7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            // 마지막 0이 2개 나오면 종료
            if (num1 == 0 && num2 == 0) {
                break;
            }
            System.out.println(num1 + num2);
        }
    }
}