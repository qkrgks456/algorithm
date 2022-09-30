package programmers.problem.level1_4;

public class Solution4 {
    public int solution(int n) {
        String num = "";
        while (n > 0) {
            num = (n % 3) + num;
            n /= 3;
        }
        StringBuilder stringBuilder = new StringBuilder(num);
        String reverse = stringBuilder.reverse().toString();
        return Integer.parseInt(reverse, 3);
    }
}
