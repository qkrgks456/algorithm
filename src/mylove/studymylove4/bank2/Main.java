package mylove.studymylove4.bank2;

public class Main {
    public static void main(String[] args) {
        Money_ver2[] users = new Money_ver2[]{
                new Money_ver2("aaa", 10000),
                new Money_ver2("bbb", 20000),
                new Money_ver2("ccc", 30000)
        };
        MoneyShow_ver2 print = new MoneyShow_ver2();
        print.show(users[0]);
        print.show(users);
    }
}
