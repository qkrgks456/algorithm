package mylove.poly.poly02;

public class Main {
    public static void main(String[] args) {
        Papa mypapa = new Son();
        System.out.println(mypapa.money);
        mypapa.sing();

        Son son = (Son) mypapa;
        System.out.println(son.money);
        // 1. 2. 3. 은 정미가 하슈 ..
    }
}
