package mylove.studymylove4.bank2;

public class MoneyCard {

    public void cardRanking(Money_ver2[] users) {  //오버로딩 하느라 두개 만든거임 이건 배열형식
        for (int i = 0; i < users.length; i++) {
            long money = users[i].getUser_won();
            if (money >= 25000) {
                users[i].setRanking("gold");
            } else if (money >= 15000) {
                users[i].setRanking("silver");
            } else {
                users[i].setRanking("green");
            }
        }
    }

    public void cardRanking(Money_ver2 user) {   //오버로딩 함 이름은 같지만 타입은 다름
        long money = user.getUser_won();
        if (money >= 25000) {
            user.setRanking("gold");
        } else if (money >= 15000) {
            user.setRanking("silver");
        } else {
            user.setRanking("green");
        }
    }
}
