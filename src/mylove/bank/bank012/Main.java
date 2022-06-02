package mylove.bank.bank012;

public class Main {
    public static void main(String[] args) {
        Bank_v5[] users = new Bank_v5[]{new Bank_v5(), new Bank_v5(), new Bank_v5()};
        Process_v5_2 process = new Process_v5_2();
        process.menu(users);
    }
}
