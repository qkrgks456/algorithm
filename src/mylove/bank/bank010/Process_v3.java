package mylove.bank.bank010;

import java.util.Scanner;

public class Process_v3 {
    Scanner scanner = new Scanner(System.in);

    public void menu(Bank_v3 user) {
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
                    input(user);
                    break; //리턴값void / 메서드명 input/ 파라미터 x
                case 2:
                    show(user);
                    break;     //리턴값void / 메서드명 show/ 파라미터 x
                case 3:
                    deposit(user);
                    break; //리턴값void / 메서드명 deposit/ 파라미터 x
                case 4:
                    withdraw(user);
                    break;//리턴값void / 메서드명 withdraw/ 파라미터 x
                case 5:
                    delete(user);
                    break;//리턴값void / 메서드명 delete/ 파라미터 x
                case 9:
                    System.out.println("종료기능입니다.");
                    break;
            }
        } while (num != 9);
    }

    public void input(Bank_v3 user) {
        System.out.print("*ID : ");
        user.setId(scanner.next());
        System.out.print("*PASS : ");
        user.setPass(scanner.next());
        System.out.print("*BALANCE : ");
        user.setBalance(scanner.nextDouble());
    }

    public void show(Bank_v3 user) {
        System.out.print("*ID : ");
        String id = scanner.next();
        System.out.print("*PASS : ");
        String pass = scanner.next();
        if (user.getId().equals(id) && user.getPass().equals(pass)) {
            System.out.println("=========조회결과=========");
            System.out.println("아이디 : " + user.getId());
            System.out.println("잔액  : " + user.getBalance());
            System.out.println("암호 : " + user.getPass());
            System.out.println("조회가 성공했습니다.");
        } else {
            System.out.println("조회가 실패했습니다.");
        }
        System.out.println("아무키나 누르세요");
        scanner.next();
    }

    public void deposit(Bank_v3 user) {
        System.out.println("====== 입금 계좌정보 입력 ======");
        System.out.print("*ID : ");
        String id = scanner.next();
        System.out.print("*PASS : ");
        String pass = scanner.next();
        if (user.getId().equals(id) && user.getPass().equals(pass)) {
            System.out.print("입금액 : ");
            double num = user.getBalance() + scanner.nextDouble();
            user.setBalance(num);
        } else {
            System.out.println("계좌 정보가 없습니다.");
        }
    }

    public void withdraw(Bank_v3 user) {
        System.out.println("====== 출금 계좌정보 입력 ======");
        System.out.print("*ID : ");
        String id = scanner.next();
        System.out.print("*PASS : ");
        String pass = scanner.next();
        if (user.getId().equals(id) && user.getPass().equals(pass)) {
            System.out.print("출금액 : ");
            double num = user.getBalance() - scanner.nextDouble();
            user.setBalance(num);
        } else {
            System.out.println("계좌 정보가 없습니다.");
        }
    }

    public void delete(Bank_v3 user) {
        System.out.print("*ID : ");
        String id = scanner.next();
        System.out.print("*PASS : ");
        String pass = scanner.next();
        if (user.getId().equals(id) && user.getPass().equals(pass)) {
            System.out.print("삭제하시겠습니까 ? (Y/N)");
            String check = scanner.next();
            if (check.equalsIgnoreCase("y")) {
                user.setId("");
                user.setPass("");
                user.setBalance(0);
            }
        } else {
            System.out.println("계좌 정보가 없습니다.");
        }
    }
}
