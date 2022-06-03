package mylove.poly.poly01;

public class Main {
    public static void main(String[] args) {
        Mama mom = new Mama();
        Son son = new Son();
        System.out.println(mom.money);

        Mama mom2 = new Son();
        Son son2 = new Son();
        son2 = (Son) mom2; // 가능 형변환 필수
        System.out.println(son2.money + "\t" + son2.car);
        // 엄마돈 10원 출력
        System.out.println(mom2.money);
    }
}
