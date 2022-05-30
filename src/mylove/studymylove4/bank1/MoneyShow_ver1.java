package mylove.studymylove4.bank1;

public class MoneyShow_ver1 {

    public void show(Money_ver1 user) {
        show_message();
        System.out.println("[USER] " + user.getUser_name() + "님의 정보입니다.");
        System.out.println("잔액  : " + user.getUser_won() + "원");
    }

    public void show(Money_ver1[] user) {
        show_message();
        System.out.println("[USER]   NAME   BALANCE   CARD");
        for (int i = 0; i < user.length; i++) {
            System.out.println("----------------------------------------------");
            System.out.println("[USER]   " + user[i].getUser_name() + "         " + user[i].getUser_won() + "원");
        }
    }

    public void show_message() {
        System.out.println("=====================================");
        System.out.println(":::::::::::::::: WELCOME! GREEN BANK");
        System.out.println("=====================================");

    }
}
