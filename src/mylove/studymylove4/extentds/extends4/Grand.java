package mylove.studymylove4.extentds.extends4;


class Grand extends Object {
    public void one() {
        System.out.println("grand : one");
    }

    public void two() {
        System.out.println("grand : two");
    }
}

class Father extends Grand {
    public void three() {
        System.out.println("father: three");
    }
}
// 오버라이딩한 Uncle의 one() two() 메서드가 우선순위를 갖는다
class Uncle extends Grand {
    public void four() {
        System.out.println("uncle : four");
    }

    // 제일 먼저 호출
    @Override
    public void one() {

        super.one();
        System.out.println("uncle : one");
    }
    // 제일 먼저 호출
    @Override
    public void two() {
        // 그 다음 부모
        super.two();
        System.out.println("uncle : two");
    }
}

// 오버라이딩한 Aunt클래스의 toString() 메서드가 우선순위를 갖는다
class Aunt extends Object {
    String name = "MiMi";

    @Override
    public String toString() {
        return name + "옆집이모클래스";
    }
}
