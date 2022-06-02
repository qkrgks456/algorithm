package mylove.studymylove5.extends1;

public class DmbCellPhone extends CellPhone {
    int channel;

    public DmbCellPhone(String model, String color, int channel) {
        super(model, color);
        this.channel = channel;
    }

    public void turnOnDmb() {
        System.out.println("채널 " + this.channel + "번 DMB 방송 수신을 시작합니다.");
    }

    public void changeChannelDmb(int channel) {
        this.channel = channel;
        System.out.println("채널 " + this.channel + "번으로 바꿉니다.");
    }

    public void turnOffDmb() {
        System.out.println("DMB 방송 수신을 멈춥니다");
    }
}
