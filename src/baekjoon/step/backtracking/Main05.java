package baekjoon.step.backtracking;

import java.util.Scanner;

public class Main05 {
    // 이해 안간다 인생 망했다 이걸 어케 함 풀이봐도 이해 안됨
    static int n, count = 0;
    static int[] ints;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        ints = new int[n];
        recursion(0);
        System.out.println(count);
    }
    // 이차원 배열 말고 일차원 배열로 x,y를 확인 한다는 건데
    // 이걸 어케 함 ㅡ.ㅡ
    public static void recursion(int depth) {
        if (n == depth) {
            count++;
            return;
        } else {
            for (int i = 0; i < n; i++) {
                ints[depth] = i;
                if (check(depth)) {
                    recursion(depth + 1);
                }
            }
        }
    }

    public static boolean check(int col) {
        for (int i = 0; i < col; i++) {
            // 동일할때?
            if (ints[i] == ints[col]) {
                return false;
            }
            // 여기가 대각선 체크고
            else if (Math.abs(col - i) == Math.abs(ints[col] - ints[i])) {
                return false;
            }
        }
        return true;
    }
}
