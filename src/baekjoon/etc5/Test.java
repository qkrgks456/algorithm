package baekjoon.etc5;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        while (true) {
            int num = 0;
            int id = 1, pass = 1;
            double balance = 10000;
            int idCheck, passCheck;
            Scanner scanner = new Scanner(System.in);
            System.out.println("1.추가");
            System.out.println("2.조회");
            System.out.println("3.입금");
            System.out.println("4.출금");
            System.out.println("5.삭제");
            System.out.println("9.종료");
            System.out.print("입력 >>> ");
            int n = scanner.nextInt();
            switch (n) {
                case 1:
                    if (id != 0 && pass != 0 && balance != 0) {
                        System.out.println("설정되어 있습니다.");
                    } else {
                        System.out.println("아이디 :");
                        id = scanner.nextInt();
                        System.out.println("비밀번호 :");
                        pass = scanner.nextInt();
                        System.out.println("잔 액 :");
                        balance = scanner.nextDouble();
                    }
                    break;
                case 2:
                    System.out.println("조회기능입니다");
                    System.out.println("본인확인ID :");
                    idCheck = scanner.nextInt();
                    System.out.println("본인확인pass :");
                    passCheck = scanner.nextInt();
                    if (idCheck == id && pass == passCheck) {
                        System.out.println("반갑습니다 고객님");
                        System.out.println("id : " + id);
                        System.out.println("pass : " + pass);
                        System.out.println("balance : " + balance);
                    } else {
                        System.out.println("다시 확인해 주세요");
                    }
                    break;
                case 3:
                    System.out.println("입금기능입니다");
                    System.out.println("본인확인ID :");
                    idCheck = scanner.nextInt();
                    System.out.println("본인확인pass :");
                    passCheck = scanner.nextInt();
                    if (idCheck == id && pass == passCheck) {
                        System.out.println("입금할 금액을 입금해주세요");
                        int count = scanner.nextInt();
                        System.out.println("잔액확인");
                        System.out.println("id : " + id);
                        System.out.println("pass : " + pass);
                        System.out.println("balance : " + balance);
                    } else {
                        System.out.println("다시 확인해 주세요");
                    }
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 9:
                    System.out.println("종료기능입니다.");
                    System.exit(0);
                    break;
            }
        }
    }
}
