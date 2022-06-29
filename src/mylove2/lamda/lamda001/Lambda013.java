package mylove2.lamda.lamda001;

import java.util.function.*;

public class Lambda013 {
    public static void main(String[] args) {
        Supplier<String> s = new Supplier<String>() {
            @Override
            public String get() {
                return "Supplier<T> 함수형 인터페이스";
            }
        };
        System.out.println(s.get());

        Supplier<String> s1 = () -> "Supplier<T> 함수형 인터페이스";
        System.out.println(s1.get());

        BooleanSupplier s2 = () -> false;
        IntSupplier s3 = () -> 5;
        LongSupplier s4 = () -> 10L;
        DoubleSupplier s5 = () -> 5.8;
        System.out.println(s2.getAsBoolean());
        System.out.println(s3.getAsInt());
        System.out.println(s4.getAsLong());
        System.out.println(s5.getAsDouble());
    }
}
