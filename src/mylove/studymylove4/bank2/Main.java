package mylove.studymylove4.bank2;

public class Main {
    public static void main(String[] args) {
        Money_ver2[] users = new Money_ver2[]{
                new Money_ver2("aaa", 10000),
                new Money_ver2("bbb", 20000),
                new Money_ver2("ccc", 30000)
        };
        MoneyShow_ver2 print = new MoneyShow_ver2();
        // MoneyShow_ver2이것은 int[] ints = new int[3]; 의  int[] 와 같고  Car car = new Car 에서 Car와 같음
        //    MoneyShow_ver2 이걸  MoneyShow_ver2 클래스에서 객체화 해주고 그 자료형으로 파라미터 받아야함
        Money_ver2 money_ver2 = new Money_ver2("aaa", 10000);
        print.show(users[0]);
        print.show(users);    //이건 오버로딩 하라고 주신거임
    }
}
