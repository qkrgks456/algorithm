package programmers.problem.level1_5;

public class Solution2 {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gdc(n, m);
        answer[1] = lcm(n, m);
        return answer;
    }

    static int gdc(int a, int b) {
        if (a < b) {
            int num = a;
            a = b;
            b = num;
        }
        while (b != 0) {
            int num = a % b;
            a = b;
            b = num;
        }
        return a;
    }

    static int lcm(int a, int b) {
        return a * b / gdc(a, b);
    }
}
