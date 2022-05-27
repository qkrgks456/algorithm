package mylove.studymylove3;

public class Main06 {
    public static void main(String[] args) {
        Car3 c1 = new Car3();
        c1.color = "red"; // 클래스 변수
        System.out.println(c1); // 인스턴스변수
        Car3 c2 = new Car3(c1);
        System.out.println(c2); // 인스턴스변수
        Car3 c3 = new Car3();
        c3.color = "green"; // 클래스 변수
        System.out.println(c3);  // 인스턴스변수
        Car3 c4 = new Car3(c3);
        System.out.println(c4); // 인스턴스변수
    }
}

class Car3 {
    String color;
    String gearType;
    int door;

    public Car3() {
        gearType = "auto";
        door = 4;
    }

    public Car3(Car3 car3) {
        this.color = car3.color;
        this.gearType = car3.gearType;
        this.door = car3.door;
    }

    @Override
    public String toString() {
        return "color=" + color + "," + " gearType=" + gearType + "," + " door=" + door;
    }
}
