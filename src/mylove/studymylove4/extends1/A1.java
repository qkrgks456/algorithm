package mylove.studymylove4.extends1;

public class A1 extends Object {
    int a;

    public A1() {
        super();
    }
}

class B1 extends A1 {
    int b;

    public B1() {
        super();
    }
}

class C1 extends B1 {
    int c;

    public C1() {
        super();
    }

    public void show() {
        System.out.println("할머니 A a :" + (a += 100));
        System.out.println("엄마 B b :" + (b += 50));
        System.out.println("나 C c :" + (c += 10));
    }
}