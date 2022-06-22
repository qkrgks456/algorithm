package mylove.thread.runnable;

import java.awt.*;

public class Thread007 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Beep());
        Thread thread2 = new Thread(new Star());
        thread.start();
        thread2.start();
    }
}

class Beep implements Runnable {
    @Override
    public void run() {
        try {
            Toolkit toolkit = Toolkit.getDefaultToolkit();
            for (int i = 0; i < 5; i++) {
                toolkit.beep();
                Thread.sleep(500);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

class Star implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 0; i < 5; i++) {
                System.out.println("*");
                Thread.sleep(700);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}



