package mylove2.lamda;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Basic1 f11 = (a, b) -> a > b ? a : b;
        System.out.println(f11.max(10, 3));
        Basic2 f21 = (name, i) -> System.out.println(name + i);
        f21.printVar("JAVA", 8);
        Basic3 f31 = (x) -> x * x;
        System.out.println(f31.square(10));
        Basic4 f41 = () -> (int) (Math.random()) * 6;
        System.out.println(f41.roll());
        int[] arr = {1, 2, 3};
        Basic5 f51 = (a) -> {
            int sum = 0;
            for (int i : a) {
                sum += i;
            }
            return sum;
        };
        System.out.println(f51.sumArr(arr));
        Basic6 f61 = () -> new int[]{};
        System.out.println(Arrays.toString(f61.emptyArr()));
        Basic7<String, Integer> f71 = (name, i) -> System.out.println(name + i);
        f71.printVar("JAVA", 8);
    }
}

interface Basic1 {
    int max(int a, int b);
}

interface Basic2 {
    void printVar(String name, int i);
}

interface Basic3 {
    int square(int x);
}

interface Basic4 {
    int roll();
}

interface Basic5 {
    int sumArr(int[] arr);
}

interface Basic6 {
    int[] emptyArr();
}

interface Basic7<String, Integer> {
    void printVar(java.lang.String name, int i);
}
