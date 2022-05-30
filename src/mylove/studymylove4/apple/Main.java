package mylove.studymylove4.apple;

public class Main {
    public static void main(String[] args) {
        Apple[] user1 = new Apple[3];
        user1[0] = new Apple();
        user1[1] = new Apple();
        user1[2] = new Apple();
        for (int i = 0; i < user1.length; i++) {
            user1[i].setOrder("홍길동");
            user1[i].setName("APPLE");
            user1[i].setNum(1);
            user1[i].setPrice(1000);
        }

        Apple_Print print = new Apple_Print();
        print.show(user1[0]);
        print.show(user1);

    }
}
