package mylove.studymylove;

public class Test6 {
    public static void main(String[] args) {
        // Ex003
        // for
        int sum = 1;  // for문이 1을 더해주면서 시작하지 않아서 sum을 0이 아닌 1로 시작한다 (괄호부터 시작해서)
        String s = "1+";   // 앞에를 1+로 출력해야해서

        for (int i = 2; i <= 10; i++) {  //i를 1로 주면 1+(1)+(1+2) 이런식으로 시작한다 1+를 앞에서 해줬기때문에 2부터 시작
            // 2 3 4 5
            s += "(";
            for (int j = 1; j <= i; j++) {
                // 1 2
                // 1 2 3
                // 1 2 3 4
                // 1 2 3 4 5  j임 계속 쁠러스됨
                sum += j;   //괄호 애들이 다 j라서 j를 써줌
                s += j + "+"; // (1+2+3+4+5+ 이상태임
            }
            s = s.substring(0, s.length() - 1) + ")+"; // (1+2+3+4+5)+ 이렇게 바뀜
        }

        System.out.println(s.substring(0, s.length() - 1) + "=" + sum);
        // while
        int i = 2;
        sum = 1;
        s = "1+";
        while (i <= 10) {
            s += "(";
            int j = 1;
            while (j <= i) {
                sum += j;
                s += j + "+";
                j++;
            }
            s = s.substring(0, s.length() - 1) + ")+";
            i++;
        }
        System.out.println(s.substring(0, s.length() - 1) + "=" + sum);
        // do while
        i = 2;
        sum = 1;
        s = "1+";
        do {
            s += "(";
            int j = 1;
            while (j <= i) {
                sum += j;
                s += j + "+";
                j++;
            }
            s = s.substring(0, s.length() - 1) + ")+";
            i++;
        } while (i <= 10);
        System.out.println(s.substring(0, s.length() - 1) + "=" + sum);
    }
}
