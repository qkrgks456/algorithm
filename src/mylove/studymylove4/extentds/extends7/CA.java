package mylove.studymylove4.extentds.extends7;

public class CA {
    private int a;

    public CA() {
        System.out.println("[CA()] 1. CA안의 a 변수 : 인스턴스 변수 a를 사용할 수 있게 생성자가 초기화");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "CA{" +
                "a=" + a +
                '}';
    }
}

class CB extends CA {
    private int b;

    public CB() {
        System.out.println("[CB()] 2. CB안의 b 변수 : 인스턴스 변수 b를 사용할 수 있게 생성자가 초기화");
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "CB{" +
                "b=" + b +
                '}';
    }
}