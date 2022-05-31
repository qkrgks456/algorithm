package mylove.studymylove4.extentds.extends1;

public class Extends002 {
    public static void main(String[] args) {
        MobileNote9 my9 = new MobileNote9();
        my9.setIris("brown");
        my9.setFace("pretty");
        my9.newShow();
    }
}

class MobileNote7 {
    private String iris;

    public MobileNote7() {
    }

    public String getIris() {
        return iris;
    }

    public void setIris(String iris) {
        this.iris = iris;
    }

    public void newShow() {
        System.out.println("::::::: NOTE7 새로운 기능(Overriding)");
        System.out.println("iris 홍채인식기능 ! ");
        System.out.println("myiris : " + this.iris);
    }

}

class MobileNote8 extends MobileNote7 {
    private String face;

    public MobileNote8() {
        super();
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    @Override
    public void newShow() {
        super.newShow();
        System.out.println("::::::: NOTE8 새로운 기능(Overriding)");
        System.out.println("face 홍채인식기능 ! ");
        System.out.println("face : " + this.face);
    }
}


class MobileNote9 extends MobileNote8 {
    private int battery;

    public MobileNote9() {
        this.battery = 24;
    }

    public MobileNote9(int battery) {
        this.battery = battery;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }

    @Override
    public void newShow() {
        super.newShow();
        System.out.println("::::::: NOTE9 새로운 기능(Overriding)");
        System.out.println("battery 하루종일 사용 가능 ! ");
        System.out.println("battery : " + this.battery);
    }
}



