package mylove2.lamda;

public class Lamda004 {
    public static void main(String[] args) {
        // 1. 원래 이 상태 인터페이스에서 익명 구현 객체를 활용하여 세팅
        A4 test = new A4() {
            @Override
            public void abc(int k) {
                System.out.println(k);
            }
        };

        // 2. 람다식을 살짝 적용해보면 괄호안에서 파라미터(int k)를 받는다고 생각하면됨
        // 괄호안이 오버라이딩 된 메서드
        A4 test1 = (k) -> {
            System.out.println(k);
        };

        // 3. if문에서도 한줄이면 {} <- 이거 안써도 됐음
        A4 test2 = k -> System.out.println(k);

        test2.abc(10);
        System.out.println();
        System.out.println();


        //람다식

        A4 a2 = k -> System.out.println(k);
        a2.abc(10);
        System.out.println();
        System.out.println();


        A4 a3 = k -> System.out.println(k);
        a3.abc(10);
        System.out.println();
        System.out.println();


        A4 a4 = System.out::println;
        a3.abc(10);
        System.out.println();
        System.out.println();


    }
}

interface A4 {
    void abc(int k);
}