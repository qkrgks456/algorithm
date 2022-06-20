package mylove.poly2.poly14;

public class Main {
    public static void main(String[] args) {
        Car24 car24 = new Car24();
        for (int i = 1; i <= 5; i++) {
            int problemLocation = car24.run();
            if (problemLocation != 0) {
                System.out.println(car24.tire24s[problemLocation].location + " HankookTire24로 교체");
                car24.tire24s[problemLocation] = new HankookTire(car24.tire24s[problemLocation].location, 15);
            }
            System.out.println("--------------------------------");
        }
    }
}
