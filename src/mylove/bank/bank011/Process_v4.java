package mylove.bank.bank011;

import java.util.Scanner;

public class Process_v4 {
    Scanner scanner = new Scanner(System.in);
    static int count = 0;

    public void menu(Bank_v4[] user) {
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

    public void input(Bank_v4[] user) {
        if (count == 3) {
            System.out.println("3개 초과");
            return;
        }
        System.out.print("*ID : ");
        user[count].setId(scanner.next());
        System.out.print("*PASS : ");
        user[count].setPass(scanner.next());
        System.out.print("*BALANCE : ");
        user[count].setBalance(scanner.nextDouble());
        count++;
    }

    public void show(Bank_v4[] user) {
        System.out.print("*ID : ");
        String id = scanner.next();
        System.out.print("*PASS : ");
        String pass = scanner.next();
        boolean check = false;
        for (Bank_v4 bank_v4 : user) {
            if (bank_v4.getId().equals(id) && bank_v4.getPass().equals(pass)) {
                System.out.println("=========조회결과=========");
                System.out.println("아이디 : " + bank_v4.getId());
                System.out.println("잔액  : " + bank_v4.getBalance());
                System.out.println("암호 : " + bank_v4.getPass());
                System.out.println("조회가 성공했습니다.");
                break;
            } else {
                check = true;
            }
        }
        if (check) {
            System.out.println("조회가 실패했습니다.");
        }
        System.out.println("아무키나 누르세요");
        scanner.next();
    }

    public void deposit(Bank_v4[] user) {
        System.out.println("====== 입금 계좌정보 입력 ======");
        System.out.print("*ID : ");
        String id = scanner.next();
        System.out.print("*PASS : ");
        String pass = scanner.next();
        boolean check = false;
        for (Bank_v4 bank_v4 : user) {
            if (bank_v4.getId().equals(id) && bank_v4.getPass().equals(pass)) {
                System.out.print("입금액 : ");
                double num = bank_v4.getBalance() + scanner.nextDouble();
                bank_v4.setBalance(num);
                break;
            } else {
                check = true;
            }
        }
        if (check) {
            System.out.println("계좌 정보가 없습니다.");
        }
    }

    public void withdraw(Bank_v4[] user) {
        System.out.println("====== 출금 계좌정보 입력 ======");
        System.out.print("*ID : ");
        String id = scanner.next();
        System.out.print("*PASS : ");
        String pass = scanner.next();
        boolean check = false;
        for (Bank_v4 bank_v4 : user) {
            if (bank_v4.getId().equals(id) && bank_v4.getPass().equals(pass)) {
                System.out.print("입금액 : ");
                double num = bank_v4.getBalance() - scanner.nextDouble();
                bank_v4.setBalance(num);
                break;
            } else {
                check = true;
            }
        }
        if (check) {
            System.out.println("계좌 정보가 없습니다.");
        }
    }

    public void delete(Bank_v4[] user) {
        System.out.print("*ID : ");
        String id = scanner.next();
        System.out.print("*PASS : ");
        String pass = scanner.next();
        boolean check = false;
        for (Bank_v4 bank_v4 : user) {
            System.out.print("삭제하시겠습니까 ? (Y/N)");
            String s = scanner.next();
            if (s.equalsIgnoreCase("y")) {
                bank_v4.setId("");
                bank_v4.setPass("");
                bank_v4.setBalance(0);
            } else {
                check = true;
            }
        }
        if (check) {
            System.out.println("계좌 정보가 없습니다.");
        }
    }
}
