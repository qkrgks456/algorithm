package mylove.bank.bank012;

public class Process_v5_2 extends Process_v5_1 {
    static int count = 0;

    public void menu(Bank_v5 user[]) {
        int num = 0;
        int n = 0;
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
                    super.input(user[count]);
                    break;
                case 2:
                    n = check(user);
                    if (n < 0) {
                        System.out.println("조회가 실패했습니다.");
                        System.out.println("아무키나 누르세요");
                        scanner.next();
                        break;
                    }
                    super.show(user[n]);
                    break;
                case 3:
                    System.out.println("====== 입금 계좌정보 입력 ======");
                    n = check(user);
                    if (n < 0) {
                        System.out.println("계좌 정보가 없습니다.");
                        break;
                    }
                    super.deposit(user[n]);
                    break; //리턴값void / 메서드명 deposit/ 파라미터 x
                case 4:
                    System.out.println("====== 출금 계좌정보 입력 ======");
                    n = check(user);
                    if (n < 0) {
                        System.out.println("계좌 정보가 없습니다.");
                        break;
                    }
                    super.withdraw(user[n]);
                    break;//리턴값void / 메서드명 withdraw/ 파라미터 x
                case 5:
                    n = check(user);
                    if (n < 0) {
                        System.out.println("계좌 정보가 없습니다.");
                        break;
                    }
                    super.delete(user[n]);
                    break;//리턴값void / 메서드명 delete/ 파라미터 x
                case 9:
                    System.out.println("종료기능입니다.");
                    break;
            }
        } while (num != 9);
    }

    public int check(Bank_v5 user[]) {
        System.out.print("*ID : ");
        String id = scanner.next();
        System.out.print("*PASS : ");
        String pass = scanner.next();
        for (int i = 0; i < user.length; i++) {
            String checkId = user[i].getId() == null ? "" : user[i].getId();
            String checkPass = user[i].getId() == null ? "" : user[i].getPass();
            if (checkId.equals(id) && checkPass.equals(pass)) {
                return i;
            }
        }
        return -1;
    }
}
