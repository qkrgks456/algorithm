package mylove.bank.bank008;

public class Main {
    public static void main(String[] args) {
        Bank_v1 user1 = new Bank_v1();
        int num = 0;
        do {
            num = user1.menu();  //리턴값int / 메서드명 menu/ 파라미터 x
            switch (num) {
                case 1:
                    user1.input();
                    break; //리턴값void / 메서드명 input/ 파라미터 x
                case 2:
                    user1.show();
                    break;     //리턴값void / 메서드명 show/ 파라미터 x
                case 3:
                    user1.deposit();
                    break; //리턴값void / 메서드명 deposit/ 파라미터 x
                case 4:
                    user1.withdraw();
                    break;//리턴값void / 메서드명 withdraw/ 파라미터 x
                case 5:
                    user1.delete();
                    break;//리턴값void / 메서드명 delete/ 파라미터 x
                case 9:
                    System.out.println("종료기능입니다.");
                    break;
            }
        } while (num != 9);
    }
}
