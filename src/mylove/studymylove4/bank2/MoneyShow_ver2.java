package mylove.studymylove4.bank2;

public class MoneyShow_ver2 {

    public void show(Money_ver2 user) {    //    MoneyShow_ver2 이걸  MoneyShow_ver2 클래스에서 객체화 해주고 그 자료형으로 파라미터 받아야함 아까 메인에 있던거 여기서 받음
        // int num(예시) 이런형식이라고 보면 됨 파라미터 자료형 변수명
        show_message();
        MoneyCard moneyCard = new MoneyCard();
        moneyCard.cardRanking(user);  //얘도 오버로딩 밑에꺼랑 이름은 똑같아도 다른거임
        System.out.println("[USER] " + user.getUser_name() + "님의 정보입니다.");
        System.out.println("잔액  : " + user.getUser_won() + "원");
        System.out.println("등급  : " + user.getRanking());
    }

    public void show(Money_ver2[] user) {   //그래서 여기서 오버로딩 함
        show_message();

        MoneyCard moneyCard = new MoneyCard();
        moneyCard.cardRanking(user);   //오버로딩
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
