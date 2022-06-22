package mylove.thread.runnable;

public class Thread008 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Hello());
        Thread thread2 = new Thread(new Cnt10());
        thread.start();
        thread2.start();
    }
}

class Hello implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                Thread.sleep(1000);
                System.out.println("Hello");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Cnt10 implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                Thread.sleep(500);
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
