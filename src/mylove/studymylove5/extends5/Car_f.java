package mylove.studymylove5.extends5;

public class Car_f {
    public int speed;

    public void speedUp() {
        speed += 1;
    }

    public final void stop() {
        System.out.println("차를 멈춤");
        speed = 0;
    }
}
