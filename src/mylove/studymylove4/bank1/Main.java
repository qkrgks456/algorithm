package mylove.studymylove4.bank1;

public class Main {
    public static void main(String[] args) {
        Money_ver1[] users = new Money_ver1[]{
                new Money_ver1("aaa", 10000),
                new Money_ver1("bbb", 20000),
                new Money_ver1("ccc", 30000)
        };
        MoneyShow_ver1 print = new MoneyShow_ver1();
        print.show(users[0]);
        print.show(users);
    }
}
