package programmers.problem.level2.level2_1;

public class Solution8 {
    public static int solution(int n) {
        int num = checkOne(n);
        while (true) {
            n++;
            int count = checkOne(n);
            if (num == count) break;
        }
        return n;
    }

    public static int checkOne(int n) {
        int result = 0;
        for (char c : Integer.toBinaryString(n).toCharArray()) {
            if (c == '1') result++;
        }
        return result;
    }
}
