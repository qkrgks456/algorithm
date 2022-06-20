package mylove.poly2.poly14;

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
            System.out.println(location + "Tire24 수명 : " + (maxRotation - accumulatedRotation) + "회");
            return true;
        }
        System.out.println("***" + location + " Tire24 펑크 ****");
        return false;
    }
}

class HankookTire extends Tire {
    public HankookTire(String location, int maxRotation) {
        super(location, maxRotation);
    }

    @Override
    public boolean roll() {
        this.location = "Hankook";
        return super.roll();
    }
}

class KumhoTire extends Tire {
    public KumhoTire(String location, int maxRotation) {
        super(location, maxRotation);
    }
}