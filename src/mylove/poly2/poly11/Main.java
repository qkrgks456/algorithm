package mylove.poly2.poly11;

public class Main {
    public static void main(String[] args) {
        ObjectTest test = new ObjectTest();
        test.show(new String("Happy"));
        test.show(new Integer(10));
        test.show(new Double(3.14));
        ObjectTest.line();
        test.showTotal(new String("Happy"));
        test.showTotal(new Integer(10));
        test.showTotal(new Double(3.14));
    }
}
