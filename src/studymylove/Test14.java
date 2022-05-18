package studymylove;

public class Test14 {
    public static void main(String[] args) {
        hap(3, 5);
        disp("7", "*");
        disp("2", "♥");
    }

    public static void hap(int n1, int n2) {
        int sum = 0;
        for (int i = n1; i <= n2; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

    public static void disp(String s1, String s2) {
        int n = Integer.parseInt(s1);
        String s = "";
        for (int i = 0; i < n; i++) {
            s += s2;
        }
        System.out.println(s);
    }
}
