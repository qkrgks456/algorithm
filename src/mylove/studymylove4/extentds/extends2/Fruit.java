package mylove.studymylove4.extentds.extends2;

public class Fruit {

    public Fruit() {
        System.out.println("\n:::: Fruit 생성자");
    }

    public static void line() {
        System.out.println("=========================================");
    }
}

class Apple extends Fruit {
    public Apple() {
        System.out.println("\n:::: Apple 생성자");
    }
}

class AppleJam extends Apple {
    public AppleJam() {
        System.out.println("\n:::: AppleJam 생성자");
    }
}
