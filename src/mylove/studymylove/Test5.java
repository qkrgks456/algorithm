package mylove.studymylove;

public class Test5 {
    public static void main(String[] args) {
        //Ex004
        // for
        int sum = 0;
        String s = "";
        for (int i = 1; ; i++) {  //첫시작이 1이라서
            if (i % 2 == 0) {
                sum += i - i * 2;   //양수의 두배한 값에 음수를 빼주면 해당 수에 음수가 나옴
                s += "(-" + i + ")+";     //if는 짝수가 출력 (-2) 이런 식으로 나오는 부분
            } else {
                sum += i;
                s += i + "+";  // 조건이 안 맞으면 여기는 홀수 부분 출력
            }
            if (sum >= 100) {
                break;           //몇까지 더해야 100이상이 되는지 알아야해서 100까지로 조건을 걸어줌
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
