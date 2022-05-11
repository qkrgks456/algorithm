package studymylove;

public class Test {
    public static void main(String[] args) {
        // Ex010
        //for
        int num = 12345;
        // 10000의 자리 : num / 10000
        int sum = num / 10000;  // sum에는 10000의 자리를 미리 더해놓기
        String s = sum + "+"; // 1+

        // 아래 포문 i=1000,100,10,1로 10씩 나눠주니까
        for (int i = 1000; i > 0; i /= 10) {
            // 자릿수 구하기
            // 1000의 자리: num % 10000 / 1000 -> i=1000
            // 100의 자리: num % 1000 / 100 -> i=100
            // 10의 자리: num % 100 / 10 -> i=10
            // 1의자리: num % 10 / 1 -> i=1
            int num2 = num % (i * 10) / i;
            s += num2 + "+";
            sum += num2;
        }
        // 1+2+3+4+5+
        // 마지막 자르고 합 넣주기
        System.out.println(s.substring(0, s.length() - 1) + "=" + sum);

        //while
        sum = num / 10000;
        s = sum + "+";
        int i = 1000;
        while (i > 0) {
            int num2 = num % (i * 10) / i;
            s += num2 + "+";
            sum += num2;
            i /= 10;
        }
        System.out.println(s.substring(0, s.length() - 1) + "=" + sum);

        //do while
        sum = num / 10000;
        s = sum + "+";
        i = 1000;
        do {
            int num2 = num % (i * 10) / i;
            s += num2 + "+";
            sum += num2;
            i /= 10;
        } while (i > 0);
        System.out.println(s.substring(0, s.length() - 1) + "=" + sum);
    }
}
