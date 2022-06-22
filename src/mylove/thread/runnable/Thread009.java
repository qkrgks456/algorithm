package mylove.thread.runnable;

public class Thread009 {
    public static void main(String[] args) {
        Thread thread = new Thread(new GuguDan());
        Thread thread2 = new Thread(new Sum65());
        thread.start();
        thread2.start();
    }
}

class GuguDan implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 2; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    Thread.sleep(500);
                    System.out.println(i + " * " + j + " = " + i * j);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class Sum65 implements Runnable {
    @Override
    public void run() {
        int sum = 0;
        try {
            for (int i = 1; i <= 100; i++) {
                Thread.sleep(1000);
                sum += i;
                System.out.println(sum);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
