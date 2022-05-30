package mylove.studymylove4.bank2;

public class MoneyShow_ver2 {

    public void show(Money_ver2 user) {
        show_message();
        MoneyCard moneyCard = new MoneyCard();
        moneyCard.cardRanking(user);
        System.out.println("[USER] " + user.getUser_name() + "님의 정보입니다.");
        System.out.println("잔액  : " + user.getUser_won() + "원");
        System.out.println("등급  : " + user.getRanking());
    }

    public void show(Money_ver2[] user) {
        show_message();
        MoneyCard moneyCard = new MoneyCard();
        moneyCard.cardRanking(user);
        System.out.println("[USER]   NAME   BALANCE    CARD");
        for (int i = 0; i < user.length; i++) {
            System.out.println("----------------------------------------------");
            System.out.println("[USER]   " + user[i].getUser_name() + "         " + user[i].getUser_won() + "원" + "    " + user[i].getRanking());
        }
    }

    public void show_message() {
        System.out.println("=====================================");
        System.out.println(":::::::::::::::: WELCOME! " + Money_ver2.BANK_NAME);
        System.out.println("=====================================");
    }
}
