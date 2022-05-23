package studymylove2;

import java.util.Scanner;

public class Main04 {
    int num = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        System.out.println("최대공약수 : " + gcd(n1, n2 % n1));
        System.out.println("최소공배수 : " + lcm(n1, n2));
    }

    public static int gcd(int n1, int n2) {
        // n1 =10 n2 =
        if (n2 == 0) {
            return n1;
        }
        return gcd(n2, n1 % n2);
    }

    public static int lcm(int n1, int n2) {
        int gcd = gcd(n1, n2 % n1);
        return (n1 / gcd) * (n2 / gcd) * gcd;
    }
}
