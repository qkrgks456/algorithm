package programmers.problem.level2.level2_2;

public class Solution5 {
    public int solution(int[] arr) {
        int num = lcm(arr[0], arr[1]);
        for (int i = 2; i < arr.length; i++) {
            num = lcm(num, arr[i]);
        }
        return num;
    }

    public int lcm(int a, int b) {
        return a * b / gdc(a, b);
    }

    public int gdc(int a, int b) {
        if (a < b) {
            int n = a;
            a = b;
            b = n;
        }
        while (b != 0) {
            int n = a % b;
            a = b;
            b = n;
        }
        return a;
    }
}
