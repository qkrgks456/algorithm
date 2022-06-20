package mylove.poly2.poly13;

public class Car23 {
    Tire frontLeftTire = new Tire("앞왼쪽", 6);
    Tire frontRightTire = new Tire("앞오른쪽", 2);
    Tire backLeftTire = new Tire("뒤왼쪽", 3);
    Tire backRightTire = new Tire("뒤오른쪽", 4);

    public int run() {
        System.out.println("[자동차가 달립니다.]");
        if (!frontLeftTire.roll()) {
            System.out.println("[자동차가 멈춥니다.]");
            return 1;
        }
        if (!frontRightTire.roll()) {
            System.out.println("[자동차가 멈춥니다.]");
            return 2;
        }
        if (!backLeftTire.roll()) {
            System.out.println("[자동차가 멈춥니다.]");
            return 3;
        }
        if (!backRightTire.roll()) {
            System.out.println("[자동차가 멈춥니다.]");
            return 4;
        }
        return 0;
    }
}
