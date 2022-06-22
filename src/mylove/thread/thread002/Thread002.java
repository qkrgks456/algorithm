package mylove.thread.thread002;

public class Thread002 {
    public static void main(String[] args) {
        Hello hello = new Hello();
        Cnt10 cnt10 = new Cnt10();
        hello.start();
        cnt10.start();
    }
}

class Hello extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                sleep(1000);
                System.out.println("Hello");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Cnt10 extends Thread {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                sleep(500);
                System.out.println(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
