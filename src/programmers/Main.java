package programmers;

public class Main {


    public static void main(String[] args) {
        long l = 1000000000000000L;
        System.out.println(toBinary(l,50));

    }


    public static String toBinary(long n, int length) {
        StringBuilder binary = new StringBuilder();
        for (long i = (1L << length - 1); i > 0; i = i / 2) {
            binary.append((n & i) != 0 ? "1" : "0");
        }
        return binary.toString();
    }
}

