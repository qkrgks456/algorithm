package programmers.problem.level1.level1_7;

public class Solution7 {
    public long solution(long n) {
        if (isInteger(Math.sqrt(n))) {
            return (long) Math.pow(Math.sqrt(n) + 1,2);
        }
        return -1;
    }

    public static boolean isInteger(double number) {
        return Math.ceil(number) == Math.floor(number);
    }
}
