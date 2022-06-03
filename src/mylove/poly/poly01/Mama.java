package mylove.poly.poly01;

public class Mama {
    int money = 10;

    public Mama() {
        super();
    }

    @Override
    public String toString() {
        return "Mama{" +
                "money=" + money +
                '}';
    }
}

class Son extends Mama {
    int money = 150;
    int car = 2;

    public Son() {
        super();
    }

    @Override
    public String toString() {
        return "Son{" +
                "money=" + money +
                ", car=" + car +
                '}';
    }
}
