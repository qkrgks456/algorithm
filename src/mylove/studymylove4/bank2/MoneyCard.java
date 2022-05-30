package mylove.studymylove4.bank2;

public class MoneyCard {

    public void cardRanking(Money_ver2[] users) {
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

    public void cardRanking(Money_ver2 user) {
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
