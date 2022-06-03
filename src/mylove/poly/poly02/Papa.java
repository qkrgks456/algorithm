package mylove.poly.poly02;

public class Papa {
    int money = 10000;

    public Papa() {
        super();
    }

    public void sing() {
        System.out.println("남행열차");
    }
}

class Son extends Papa {
    int money = 1500;

    public Son() {
        super();
    }

    @Override
    public void sing() {
        System.out.println("아이유 - strawberry moon");
    }
}
