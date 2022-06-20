package mylove.poly2.poly14;

public class Car24 {
    Tire[] tire24s = {
            new Tire("앞왼쪽", 6),
            new Tire("앞오른쪽", 2),
            new Tire("뒤왼쪽", 3),
            new Tire("뒤오른쪽", 4)
    };

    public int run() {
        System.out.println("[자동차가 달립니다.]");
        for (int i = 0; i < tire24s.length; i++) {
            if (!tire24s[i].roll()) {
                System.out.println("[자동차가 멈춥니다.]");
                return i;
            }
        }
        return 0;
    }
}
