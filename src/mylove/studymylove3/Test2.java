package mylove.studymylove3;

public class Test2 {
    public static void main(String[] args) {
        Car c1 = new Car();
        c1.setColor("white");
        c1.setGearType("auto");
        c1.door = 4;

        Car c2 = new Car("white", "auto", 4);
        System.out.println(c1);
        System.out.println(c2);
    }
}
