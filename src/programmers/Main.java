package programmers;

public class Main {

    public static void main(String[] args) {
        System.out.println(numCount(14));
    }

    public static int numCount(int n) {
        int count = 0;
        for (int i = 1; i * i <= n; i++) {
            if (i * i == n) count++;
            else if (n % i == 0) count += 2;
        }
        return count;
    }
}

