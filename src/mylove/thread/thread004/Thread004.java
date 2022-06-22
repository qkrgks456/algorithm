package mylove.thread.thread004;

public class Thread004 {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5};
        String[] strArray = {"하나", "둘", "셋", "넷", "다섯"};
        Thread01 thread01 = new Thread01(intArray);
        Thread02 thread02 = new Thread02(strArray);
        thread01.start();
        thread02.start();

    }
}

class Thread01 extends Thread {
    int[] intArray;

    public Thread01(int[] intArray) {
        this.intArray = intArray;
    }

    @Override
    public void run() {
        for (int i = 0; i < intArray.length; i++) {
            System.out.print("(비디오프레임) " + intArray[i] + "-");
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread02 extends Thread {
    String[] strArray;

    public Thread02(String[] strArray) {
        this.strArray = strArray;
    }

    @Override
    public void run() {
        for (int i = 0; i < strArray.length; i++) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("(자막번호) " + strArray[i]);
        }
    }
}
