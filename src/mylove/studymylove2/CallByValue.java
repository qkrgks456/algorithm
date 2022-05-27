package mylove.studymylove2;

public class CallByValue {
    public static void main(String[] args) {
        String x = "안녕";
        String y = "바보";
        System.out.println("x = " + x + " y = " + y);
        method1(x, y);
        System.out.println("x = " + x + " y = " + y);
    }

    public static void method1(String x, String y) {
        x = "쑤바";
        y = "쌍바";
        System.out.println("x = " + x + " y = " + y);
    }

}
