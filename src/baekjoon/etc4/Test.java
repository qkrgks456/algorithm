package baekjoon.etc4;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int kor = scanner.nextInt();
        int eng = scanner.nextInt();
        int math = scanner.nextInt();
        int total = kor + eng + math;
        float avg = (float) total / 3;
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println(":: GREEN IT SCORE ::");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("국어 영어 수학 총점 평균 레벨");
        System.out.println(kor + " " + eng + " " + math + " " + total + " " + avg + " Lv" + (int) Math.floor(avg) / 10);
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");

    }
}
