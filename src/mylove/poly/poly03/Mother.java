package mylove.poly.poly03;

public class Mother {
    int ma = 10;
    int mb = 20;

    public Mother() {
    }

    public Mother(int ma) {
        this.ma = ma;
    }

    public Mother(int ma, int mb) {
        this.ma = ma;
        this.mb = mb;
    }

    public void func() {
        System.out.println("==Mother");
    }
}

class Daugther extends Mother {
    int mb = 30;
    int mc = 40;

    public Daugther() {
    }

    public Daugther(int ma, int mb, int mc) {
        super(ma);
        this.mb = mb;
        this.mc = mc;
    }

    public Daugther(int ma, int mb) {
        super(ma, mb);
    }

    @Override
    public void func() {
        System.out.println("==Daugther");
    }
}
