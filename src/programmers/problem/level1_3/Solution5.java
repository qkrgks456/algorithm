package programmers.problem.level1_3;

public class Solution5 {
    public int solution(int n) {
        return decimal(n);
    }

    public static void main(String[] args) {
        System.out.println(decimal(1000000));
    }

    public static int decimal(int n) {
        int[] ints = new int[n + 1];
        // 배열에 원소 삽입
        for (int i = 2; i < ints.length; i++) {
            ints[i] = i;
        }

        for (int i = 2; i * i <= n; i++) {
            if (ints[i] == 0) continue;
            for (int j = i * i; j <= n; j += i) {
                ints[j] = 0;
            }
        }
        int result = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != 0) result++;
        }
        return result;
    }
}
