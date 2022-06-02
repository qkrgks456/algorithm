package mylove.bank.bank011;

public class Main {
    public static void main(String[] args) {
        Bank_v4[]  users = new Bank_v4[] {  new Bank_v4() , new Bank_v4() ,new Bank_v4()  };
        Process_v4 process = new Process_v4();
        process.menu(users);
    }
}
