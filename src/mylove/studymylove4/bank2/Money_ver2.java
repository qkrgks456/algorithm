package mylove.studymylove4.bank2;

public class Money_ver2 {
    static final String BANK_NAME = "GREEN BANK";
    static double rate = 0.1;
    private String user_name;
    private long user_won;
    private String ranking;

    public Money_ver2(String user_name, long user_won) {
        this.user_name = user_name;
        this.user_won = user_won;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public long getUser_won() {
        return user_won;
    }

    public void setUser_won(long user_won) {
        this.user_won = user_won;
    }
}
