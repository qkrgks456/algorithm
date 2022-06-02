package mylove.studymylove5.extends1;

public class Main {
    public static void main(String[] args) {
        DmbCellPhone dmbCellPhone = new DmbCellPhone("자바폰", "검정", 10);
        System.out.println("1. 모델 : " + dmbCellPhone.model);
        System.out.println("2. 색상 : " + dmbCellPhone.color);
        System.out.println("3. 채널 : " + dmbCellPhone.channel);

        dmbCellPhone.powerOn();
        dmbCellPhone.bell();
        dmbCellPhone.sendVoice("여보세요");
        dmbCellPhone.receiveVoice("안녕하세요! 저는 홍길동인데요");
        dmbCellPhone.sendVoice("아 ~ 예 반갑습니다");
        dmbCellPhone.hangUp();

        dmbCellPhone.turnOnDmb();
        dmbCellPhone.changeChannelDmb(12);
        dmbCellPhone.turnOffDmb();
    }
}
