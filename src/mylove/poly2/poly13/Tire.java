package mylove.poly2.poly13;

public class Tire {
    public int maxRotation;
    public int accumulatedRotation;
    public String location;

    public Tire(String location, int maxRotation) {
        this.location = location;
        this.maxRotation = maxRotation;
    }

    public boolean roll() {
        ++accumulatedRotation;
        if (accumulatedRotation < maxRotation) {
            System.out.println(location + "Tire 수명" + (maxRotation - accumulatedRotation) + "회");
            return true;
        }
        System.out.println("***" + location + "Tire 펑크 ****");
        return false;
    }
}

class HankookTire extends Tire {
    public HankookTire(String location, int maxRotation) {
        super(location, maxRotation);
        roll();
    }

    @Override
    public boolean roll() {
        System.out.println(super.location + "HankookTire로 교체");
        return false;
    }
}

class KumhoTire extends Tire {
    public KumhoTire(String location, int maxRotation) {
        super(location, maxRotation);
        roll();
    }

    @Override
    public boolean roll() {
        System.out.println(super.location + "KumhoTire로 교체");
        return false;
    }
}