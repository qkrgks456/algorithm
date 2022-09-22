package programmers.kakao.test2022;

public class Solution2 {
    public int solution(int n, int k) {
        int answer = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (n > 0) {
            stringBuilder.insert(0, n % k);
            n /= k;
        }
        String s = stringBuilder.toString();
        String[] strings = s.split("0");
        for (int i = 0; i < strings.length; i++) {
            if (!strings[i].equals("")) {
                long num = Long.parseLong(strings[i]);
                if (numCheck(num)) answer++;
            }
        }
        return answer;
    }

    public static boolean numCheck(long n) {
        if (n <= 1) return false;
        else if (n == 2 || n == 3) return true;
        for (int i = 3; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
