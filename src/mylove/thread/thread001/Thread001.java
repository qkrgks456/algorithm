package mylove.thread.thread001;

public class Thread001 {
    public static void main(String[] args) {
        Thread001_A thread001_a = new Thread001_A();
        thread001_a.start();
    }
}

class Thread001_A extends Thread {
    @Override
    public void run() {
        System.out.println("스레드 테스트");
    }
}
