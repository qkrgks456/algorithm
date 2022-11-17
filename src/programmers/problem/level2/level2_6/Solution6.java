package programmers.problem.level2.level2_6;

public class Solution6 {
    static int[] ch2 = new int[9999999];
    static int[] ch;
    static int result = 0;

    public int solution(String numbers) {
        ch = new int[numbers.length()];
        DFS(0, "", numbers);
        return result;
    }

    public void DFS(int level, String s, String num) {
        if (level == num.length() + 1) return;
        if (!s.equals("")) {
            int check = Integer.parseInt(s);
            if (ch2[check] == 0) {
                ch2[check] = 1;
                if (!prime(Integer.parseInt(s))) result++;
            }
        }
        for (int i = 0; i < num.length(); i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                DFS(level + 1, s + num.charAt(i), num);
                ch[i] = 0;
            }
        }
    }

    public static boolean prime(int num) {
        if (num == 0 || num == 1) return true;
        // 1은 소수도 합성수도 아니므로 i는 2부터 시작한다.
        // 2의 경우 반복문이 실행되지 않으므로 defalt값으로 실행된다.
        for (int i = 2; i < num; i++) {
            // 1과 num 자신 외에 나누어지는 수가 있는지 검사할 조건문
            if (num % i == 0) {
                // 나누어지는 수가 있을 경우 isPrime의 값을 true로 바꾼다.
                return true;
            }
        }
        // 위 조건문의 결과에 따라 아래의 조건문을 실행한다.
        return false;
    }
}
