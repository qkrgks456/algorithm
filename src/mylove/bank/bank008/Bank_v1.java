package mylove.bank.bank008;

import java.util.Scanner;

public class Bank_v1 {
    String id;
    String pass;
    double balance;
    static String Company = "(주) 유정미";
    Scanner scanner = new Scanner(System.in);

    public int menu() {
        System.out.println("==========BANK===========");
        System.out.println("1. 추가");
        System.out.println("2. 조회");
        System.out.println("3. 입금");
        System.out.println("4. 출금");
        System.out.println("5. 삭제");
        System.out.println("9. 종료");
        System.out.print("입력 >> ");
        return scanner.nextInt();
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
