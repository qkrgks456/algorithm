package baekjoon.etc4;

public class Test {
    public static void main(String[] args) {
        int a = 10;
        int b = 3;

        // 3.3333333333333
        double num = (double) a / b;
        // 3.33 / 100.0
        System.out.println("10 / 3 = " + Math.round(num * 100) / 100.0);
    }
}
