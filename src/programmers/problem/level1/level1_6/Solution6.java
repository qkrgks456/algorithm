package programmers.problem.level1.level1_6;

public class Solution6 {
    public long solution(int a, int b) {
        long result = 0;
        if (a > b) {
            for (int i = b; i <= a; i++) {
                result += i;
            }
        } else if (b > a) {
            for (int i = a; i <= b; i++) {
                result += i;
            }
        } else {
            result = a;
        }
        return result;
    }
}
