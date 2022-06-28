package mylove.thread.thread007;

public class Thread035 {
    public static void main(String[] args) {
        DataBox24 dataBox24 = new DataBox24();

        Producer24 producer24 = new Producer24(dataBox24);
        Consumer24 consumer24 = new Consumer24(dataBox24);
        producer24.start();
        consumer24.start();
    }
}

class Consumer24 extends Thread {
    private DataBox24 dataBox24;

    public Consumer24(DataBox24 dataBox24) {
        this.dataBox24 = dataBox24;
    }

    @Override
    public void run() {
        try {
            sleep(50);
        } catch (Exception e) {
        }

        for (int i = 1; i <= 3; i++) {
            dataBox24.getData();
        }
    }
}

class Producer24 extends Thread {
    private DataBox24 dataBox24;

    public Producer24(DataBox24 dataBox24) {
        this.dataBox24 = dataBox24;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 3; i++) {
            String data = "Data-" + i;
            dataBox24.setData(data);
        }
    }
}

class DataBox24 {
    private String data;

    public synchronized void getData() {
        System.out.println("Consumer24가 읽은 데이터 : " + this.data);
        notify();
        try {
            wait();
        } catch (Exception e) {

        }
    }

    public synchronized void setData(String data) {
        this.data = data;
        System.out.println("Producer24가 생성한 데이터 : " + data);
        notify();
        try {
            wait();
        } catch (Exception e) {

        }
    }
}
