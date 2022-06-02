package mylove.bank.bank012;

import java.util.Scanner;

public class Process_v5_1 {
    Scanner scanner = new Scanner(System.in);

    public void input(Bank_v5 user) {
        System.out.print("*ID : ");
        user.setId(scanner.next());
        System.out.print("*PASS : ");
        user.setPass(scanner.next());
        System.out.print("*BALANCE : ");
        user.setBalance(scanner.nextDouble());
        Process_v5_2.count++;
    }

    public void show(Bank_v5 user) {
        System.out.println("=========조회결과=========");
        System.out.println("아이디 : " + user.getId());
        System.out.println("잔액  : " + user.getBalance());
        System.out.println("암호 : " + user.getPass());
        System.out.println("조회가 성공했습니다.");
        System.out.println("아무키나 누르세요");
        scanner.next();
    }

    public void deposit(Bank_v5 user) {
        System.out.print("입금액 : ");
        double num = user.getBalance() + scanner.nextDouble();
        user.setBalance(num);

    }

    public void withdraw(Bank_v5 user) {
        System.out.print("출금액 : ");
        double num = user.getBalance() - scanner.nextDouble();
        user.setBalance(num);
    }

    public void delete(Bank_v5 user) {
        System.out.print("삭제하시겠습니까 ? (Y/N)");
        String check = scanner.next();
        if (check.equalsIgnoreCase("y")) {
            user.setId("");
            user.setPass("");
            user.setBalance(0);
            Process_v5_2.count--;
        }
    }
}
