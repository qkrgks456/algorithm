package mylove.studymylove4.extentds.extends3;

public class Fruit2 {
    public Fruit2() {
        System.out.println(":: Fruit 생성자");
    }

    public static void line() {
        System.out.println("==============================");
    }

    public void star(int s) {
        System.out.println(":::::::: FRUIT" + s);
    }
}

class Apple2 extends Fruit2 {
    public Apple2() {
        System.out.println(":: Apple 생성자");
    }

    @Override
    public void star(int s) {
        switch (s) {
            case 5:
                System.out.println("=BEST");
                break;
            case 4:
                System.out.println("=GOOD");
                break;
            case 3:
                System.out.println("=SOSO");
                break;
            case 2:
                System.out.println("=NOT BAD");
                break;
            case 1:
                System.out.println("=BBBBAD");
                break;
        }
    }
}

class AppleJam2 extends Apple2 {
    public AppleJam2() {
        System.out.println(":: AppleJam 생성자");
    }

    @Override
    public void star(int s) {
        super.star(s);
        for (int i = 0; i < s; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
