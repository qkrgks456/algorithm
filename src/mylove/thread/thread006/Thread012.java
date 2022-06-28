package mylove.thread.thread006;

public class Thread012 {
    public static void main(String[] args) {
        // 코어 = 컴퓨터의 뇌
        // 코어가 10개면 사용가능한 뇌가 10개
        // 사용가능한 코어가 많을수록 성능이 당연히 좋다
        System.out.println("코어수 :" + Runtime.getRuntime().availableProcessors());

        // 스레드를 20개 만들었는데
        // 19번째의 스레드만 우선순위를 10으로 높였다
        // 나머지 스레드들은 우선순위 기본값 5
        // 실행시켜보면 우선순위를 높게 줬다고 해서 무조건적으로 먼저 실행되거나 하지는 않는다
        for (int i = 0; i < 20; i++) {
            Thread thread = new MyThread();
            if (i == 19) thread.setPriority(10);
            thread.start();
        }
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        for (long i = 0; i < 000000000; i++) {
        }
        System.out.println(getName() + "우선순위 :" + getPriority());
    }
}
