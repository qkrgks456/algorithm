package mylove.bank.bank011;

public class Bank_v4 {
    private String id;
    private String pass;
    private double balance;
    static String Company = "(주) 유정미";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
