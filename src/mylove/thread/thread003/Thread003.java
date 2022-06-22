package mylove.thread.thread003;

public class Thread003 {
    public static void main(String[] args) {
        GuguDan guguDan = new GuguDan();
        Sum65 sum65 = new Sum65();
        guguDan.start();
        sum65.start();
    }
}

class GuguDan extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 2; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    sleep(500);
                    System.out.println(i + " * " + j + " = " + i * j);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class Sum65 extends Thread {
    @Override
    public void run() {
        int sum = 0;
        try {
            for (int i = 1; i <= 100; i++) {
                sleep(1000);
                sum += i;
                System.out.println(sum);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}