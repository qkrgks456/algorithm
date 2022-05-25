package studymylove3;

public class Main03 {
    public static void main(String[] args) {
        Car6 car6 = new Car6();
        System.out.println("car6.company : " + car6.company);
        System.out.println();
        car6 = new Car6("자가용");
        System.out.println("car6.company : " + car6.company);
        System.out.println("car6.model : " + car6.model);
        System.out.println();
        car6 = new Car6("자가용", "빨강");
        System.out.println("car6.company : " + car6.company);
        System.out.println("car6.model : " + car6.model);
        System.out.println("car6.color : " + car6.color);
        System.out.println();
        car6 = new Car6("자가용", "빨강", 200);
        System.out.println("car6.company : " + car6.company);
        System.out.println("car6.model : " + car6.model);
        System.out.println("car6.color : " + car6.color);
        System.out.println("car6.maxSpeed : " + car6.maxSpeed);
    }
}

class Car6 {
    String company = "현대자동차";
    String model;
    String color;
    int maxSpeed;

    public Car6() {
    }

    public Car6(String model) {
        this.model = model;
    }

    public Car6(String model, String color) {
        this.model = model;
        this.color = color;
    }

    public Car6(String model, String color, int maxSpeed) {
        this.model = model;
        this.color = color;
        this.maxSpeed = maxSpeed;
    }
}

