package programmers.problem.level2.level2_5;

public class Solution2 {
    public String solution(int n, int t, int m, int p) {
        int num = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while (true) {
            stringBuilder.append(radix(num, n));
            if (stringBuilder.length() >= t * m) {
                break;
            }
            num++;
        }
        String[] strings = stringBuilder.toString().split("");
        stringBuilder = new StringBuilder();
        int tCount = 0;
        int pCount = 1;
        for (int i = 0; i < strings.length; i++) {
            if ((i + 1) % m == 0) {
                tCount++;
            }
            if (pCount == p) {
                stringBuilder.append(strings[i]);
            }
            pCount++;
            if (pCount == m + 1) {
                pCount = 1;
            }
            if (tCount == t) break;
        }
        return stringBuilder.toString();
    }


    public static String radix(int num, int n) {
        StringBuilder sb = new StringBuilder();

        // 숫자가 0이면 0을 리턴
        if (num == 0) return "0";

        while (num > 0) {
            // 나머지가 1자릿수면 그대로 추가
            if (num % n < 10) {
                sb.append(num % n);

                // 10, 11, 12 .. 의 경우 알파벳을 추가해야함. 10=A, 11=B ...
            } else {
                sb.append((char) (num % n - 10 + 'A'));
            }
            // 추가가 끝났다면 n으로 나눈 몫을 다시 계산
            num /= n;
        }

        // 계산한 나머지값의 역순으로 만들어야한다.
        return sb.reverse().toString();
    }
}
