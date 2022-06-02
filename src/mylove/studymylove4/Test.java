package mylove.studymylove4;

public class Test {
    public static void main(String[] args) throws Exception {
        Test2 test2 = new Test2();
        System.out.println(test2.n);
        Test2 test1 = (Test2) test2.clone();
        System.out.println(test1.n);
    }
}

class Test2 implements Cloneable{
    int n = 2;
    String s = "안녕";

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}