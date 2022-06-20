package mylove.poly2.poly12;

public class ObjectTest2 {
    public static Object disp(int num) {
        switch (num) {
            case 1:
                return new Dog("alpha");
            case 2:
                return new Cat("sally");
            case 3:
                return new Pig("buja");
        }
        return null;
    }
}
