package mylove2.lamda.lamda001;

import java.util.function.*;

public class Lambda015 {
    public static void main(String[] args) {
        Function<String, Integer> f = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };
        System.out.println(f.apply("안녕"));
        Function<String, Integer> f1 = str -> str.length();
        System.out.println(f1.apply("안녕"));

        IntFunction<Double> f2 = value -> Double.valueOf(value);
        LongFunction<String> f3 = value -> String.valueOf(value);
        DoubleFunction<Integer> f4 = value -> (int) value;
        BiFunction<String, Integer, String> f5 = (s, value) -> "이름은 = " + s + " 나이는 = " + value;
        System.out.println(f2.apply(10));
        System.out.println(f3.apply(20L));
        System.out.println(f4.apply(30.5));
        System.out.println(f5.apply("홍길동", 16));
        System.out.println();

        ToIntFunction<String> f6 = value -> value.length();
        ToLongFunction<Double> f7 = value -> Double.valueOf(value).longValue();
        ToDoubleFunction<Integer> f8 = value -> (double) value;
        System.out.println(f6.applyAsInt("반갑습니다"));
        System.out.println(f7.applyAsLong(58.254));
        System.out.println(f8.applyAsDouble(250));
    }
}
