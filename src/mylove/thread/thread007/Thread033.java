package mylove.thread.thread007;

public class Thread033 {
    public static void main(String[] args) {
        DataBox dataBox = new DataBox();
        Thread t1 = new Thread(() -> {
            for (int i = 1; i < 9; i++) {
                dataBox.inputData(i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i < 9; i++) {
                dataBox.outputData();
            }
        });
        t1.start();
        t2.start();
    }
}

class DataBox {
    int data;

    synchronized void inputData(int data) {
        this.data = data;
        System.out.println("입력 데이터 : " + data);
        notify();
        try {
            wait();
        }catch (Exception e){

        }
    }

    synchronized void outputData() {
        System.out.println("출력 데이터 : " + data);
        notify();
        try {
            wait();
        }catch (Exception e){

        }
    }
}
