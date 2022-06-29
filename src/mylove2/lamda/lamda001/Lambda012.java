package mylove2.lamda.lamda001;

import java.util.function.*;

public class Lambda012 {
    public static void main(String[] args) {
        Consumer<String> c = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };

        Consumer<String> c1 = t -> System.out.println(t);
        c1.accept("Consumer<T> 함수형 인터페이스");

        IntConsumer c2 = value -> System.out.println(value);
        LongConsumer c3 = value -> System.out.println(value);
        DoubleConsumer c4 = value -> System.out.println(value);
        BiConsumer c5 = (s, value) -> System.out.println("이름=" + s + " 나이=" + value);
        c2.accept(5);
        c3.accept(5L);
        c4.accept(7.8);
        c5.accept("홍길동", 16);
    }
}
