package baekjoon.etc5;

import java.util.Scanner;

public class Test {
    static int id = 1, pass = 1;
    static double balance = 10000;

    public static void main(String[] args) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("-----------------------------------------");
            System.out.println("1.추가");
            System.out.println("2.조회");
            System.out.println("3.입금");
            System.out.println("4.출금");
            System.out.println("5.삭제");
            System.out.println("9.종료");
            System.out.println("-----------------------------------------");
            System.out.print("입력 >>> ");
            int n = scanner.nextInt();
            switch (n) {
                case 1:
                    System.out.println("아이디 : " + id);
                    System.out.println("비밀번호 : " + pass);
                    System.out.println("잔액 : " + balance);
                    System.out.println("설정되어 있습니다.");
                    break;
                case 2:
                    System.out.println("조회기능입니다");
                    if (idPassCheck(scanner)) {
                        System.out.println("반갑습니다 고객님");
                        userData();
                    } else {
                        System.out.println("다시 확인해 주세요");
                    }
                    break;
                case 3:
                    System.out.println("입금기능입니다");
                    if (idPassCheck(scanner)) {
                        System.out.println("입금할 금액을 입금해주세요");
                        balance += scanner.nextDouble();
                        userData();
                    } else {
                        System.out.println("다시 확인해 주세요");
                    }
                    break;
                case 4:
                    System.out.println("출금기능입니다.");
                    if (idPassCheck(scanner)) {
                        System.out.println("출금할 금액을 입력해주세요");
                        balance -= scanner.nextDouble();
                        userData();
                    } else {
                        System.out.println("다시 확인해 주세요");
                    }
                    break;
                case 5:
                    System.out.println("삭제 기능 입니다.");
                    id = 0;
                    pass = 0;
                    balance = 0;
                    userData();
                    break;
                case 9:
                    System.out.println("종료기능입니다.");
                    System.exit(0);
                    break;
            }
        }
    }

    public static boolean idPassCheck(Scanner scanner) {
        System.out.println("본인확인ID :");
        int idCheck = scanner.nextInt();
        System.out.println("본인확인pass :");
        int passCheck = scanner.nextInt();
        if (idCheck == id && passCheck == pass) {
            return true;
        } else {
            return false;
        }
    }

    public static void userData() {
        System.out.println("잔액확인");
        System.out.println("id : " + id);
        System.out.println("pass : " + pass);
        System.out.println("balance : " + balance);
    }
}
