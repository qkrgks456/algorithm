package mylove.studymylove2;

public class CallByValue {
    public static void main(String[] args) {
        Integer x = new Integer(3);
        Integer y = new Integer(5);
        System.out.println("x = " + x + " y = " + y);
        method1(x, y);
        System.out.println("x = " + x + " y = " + y);
    }

    public static void method1(int x, int y) {
        x = 28;
        y = 26;
        System.out.println("x = " + x + " y = " + y);
    }
}
