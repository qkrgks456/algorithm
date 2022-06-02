package mylove.bank.bank009;

import java.util.Scanner;

public class Bank_v2 {
    private String id;
    private String pass;
    private double balance;
    static String Company = "(주) 유정미";
    Scanner scanner = new Scanner(System.in);

    public void menu() {
        int num = 0;
        do {
            System.out.println("==========BANK===========");
            System.out.println("1. 추가");
            System.out.println("2. 조회");
            System.out.println("3. 입금");
            System.out.println("4. 출금");
            System.out.println("5. 삭제");
            System.out.println("9. 종료");
            System.out.print("입력 >> ");
            num = scanner.nextInt();
            switch (num) {
                case 1:
                    input();
                    break; //리턴값void / 메서드명 input/ 파라미터 x
                case 2:
                    show();
                    break;     //리턴값void / 메서드명 show/ 파라미터 x
                case 3:
                    deposit();
                    break; //리턴값void / 메서드명 deposit/ 파라미터 x
                case 4:
                    withdraw();
                    break;//리턴값void / 메서드명 withdraw/ 파라미터 x
                case 5:
                    delete();
                    break;//리턴값void / 메서드명 delete/ 파라미터 x
                case 9:
                    System.out.println("종료기능입니다.");
                    break;
            }
        } while (num != 9);
    }

    public void input() {
        System.out.print("*ID : ");
        this.id = scanner.next();
        System.out.print("*PASS : ");
        this.pass = scanner.next();
        System.out.print("*BALANCE : ");
        this.balance = scanner.nextDouble();
    }

    public void show() {
        System.out.print("*ID : ");
        String id = scanner.next();
        System.out.print("*PASS : ");
        String pass = scanner.next();
        if (this.id.equals(id) && this.pass.equals(pass)) {
            System.out.println("=========조회결과=========");
            System.out.println("아이디 : " + this.id);
            System.out.println("잔액  : " + this.balance);
            System.out.println("암호 : " + this.pass);
            System.out.println("조회가 성공했습니다.");
        } else {
            System.out.println("조회가 실패했습니다.");
        }
        System.out.println("아무키나 누르세요");
        scanner.next();
    }

    public void deposit() {
        System.out.println("====== 입금 계좌정보 입력 ======");
        System.out.print("*ID : ");
        String id = scanner.next();
        System.out.print("*PASS : ");
        String pass = scanner.next();
        if (this.id.equals(id) && this.pass.equals(pass)) {
            System.out.print("입금액 : ");
            this.balance += scanner.nextDouble();
        } else {
            System.out.println("계좌 정보가 없습니다.");
        }
    }

    public void withdraw() {
        System.out.println("====== 출금 계좌정보 입력 ======");
        System.out.print("*ID : ");
        String id = scanner.next();
        System.out.print("*PASS : ");
        String pass = scanner.next();
        if (this.id.equals(id) && this.pass.equals(pass)) {
            System.out.print("출금액 : ");
            this.balance -= scanner.nextDouble();
        } else {
            System.out.println("계좌 정보가 없습니다.");
        }
    }

    public void delete() {
        System.out.print("*ID : ");
        String id = scanner.next();
        System.out.print("*PASS : ");
        String pass = scanner.next();
        if (this.id.equals(id) && this.pass.equals(pass)) {
            System.out.print("삭제하시겠습니까 ? (Y/N)");
            String check = scanner.next();
            if (check.equalsIgnoreCase("y")) {
                this.id = "";
                this.pass = "";
                this.balance = 0;
            }
        } else {
            System.out.println("계좌 정보가 없습니다.");
        }
    }
}
