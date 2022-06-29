package mylove2.lamda.lamda001;

import java.util.function.*;

public class Lambda014 {
    public static void main(String[] args) {
        Predicate<String> p = new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return (s.length() > 0) ? true : false;
            }
        };
        System.out.println(p.test("안녕"));
        Predicate<String> p1 = (s) -> (s.length() > 0) ? true : false;
        System.out.println(p1.test("안녕"));
        System.out.println();

        IntPredicate p2 = (value) -> (value % 2 == 0) ? true : false;
        LongPredicate p3 = (value) -> (value > 100) ? true : false;
        DoublePredicate p4 = (value) -> (value > 0) ? true : false;
        BiPredicate<String, String> p5 = (s1, s2) -> (s1.equals(s2)) ? true : false;

        System.out.println(p2.test(2));
        System.out.println(p3.test(85L));
        System.out.println(p4.test(-5.8));
        System.out.println(p5.test("안녕","안녕"));
    }
}
