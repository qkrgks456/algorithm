package studymylove;

public class Test {
    public static void main(String[] args) {
        // ex004
        // for
        int sum = 0;
        String s = "";
        for (int i = 1; ; i++) {
            if (i % 2 == 0) {
                sum += i - i * 2;
                s += "(-" + i + ")+";
            } else {
                sum += i;
                s += i + "+";
            }
            if (sum >= 100) {
                break;
            }
        }
        System.out.println(s.substring(0, s.length() - 1));
        // while
        sum = 0;
        s = "";
        int i = 1;
        while (true) {
            if (i % 2 == 0) {
                sum += i - i * 2;
                s += "(-" + i + ")+";
            } else {
                sum += i;
                s += i + "+";
            }
            if (sum >= 100) {
                break;
            }
            i++;
        }
        System.out.println(s.substring(0, s.length() - 1));
        // do while
        sum = 0;
        s = "";
        i = 1;
        do {
            if (i % 2 == 0) {
                sum += i - i * 2;
                s += "(-" + i + ")+";
            } else {
                sum += i;
                s += i + "+";
            }
            if (sum >= 100) {
                break;
            }
            i++;
        } while (true);
        System.out.println(s.substring(0, s.length() - 1));
    }
}
