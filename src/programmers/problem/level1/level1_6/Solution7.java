package programmers.problem.level1.level1_6;

public class Solution7 {
    public static int solution(int num) {
        long res = num;
        if (res == 1) return 0;
        for (int i = 1; i <= 500; i++) {
            res = res % 2 == 0 ? res / 2 : res * 3 + 1;
            if (res == 1) return i;
        }
        return -1;
    }
}
