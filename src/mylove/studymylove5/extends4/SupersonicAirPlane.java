package mylove.studymylove5.extends4;

public class SupersonicAirPlane extends AirPlane {
    public static final int NORMAL = 1;
    public static final int SUPERSONIC = 2;
    public int flyMode;

    public SupersonicAirPlane() {
        this.flyMode = NORMAL;
    }

    @Override
    public void fly() {
        if (this.flyMode == NORMAL) {
            super.fly();
        } else {
            System.out.println("초음속비행합니다");
        }
    }
}
