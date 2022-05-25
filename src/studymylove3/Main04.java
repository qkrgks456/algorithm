package studymylove3;

public class Main04 {
    public static void main(String[] args) {
        Car7 myCar7 = new Car7("포르쉐");
        Car7 yourCar7 = new Car7("벤츠");

        myCar7.run();
        yourCar7.run();
    }
}

class Car7 {
    String model;
    int speed;

    public Car7(String model) {
        this.model = model;
    }

    void setSpeed(int speed) {
        this.speed = speed;
    }

    public void run() {
        setSpeed(50);
        for (int i = 10; i <= this.speed; i += 10) {
            System.out.println(model + "가 달립니다.(시속:" + i + "km/h)");
        }
    }
}