package programmers.problem.level2.level2_8;

public class Solution8 {
    public long solution(int w, int h) {
        int n = gdc(w, h);
        return (long) w * h - ((w - n) + (h - n) + n);
    }

    int gdc(int a, int b) { //최대 공약수
        // 유클리드 호제법 조건
        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }
        while (b != 0) { // 유클리드 호제법
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
