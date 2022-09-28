package programmers.problem.level1_3;

import java.util.Arrays;

public class Solution3 {
    static int[] check;
    static int[] check2;
    static int[] ints;
    static int result = 0;

    public int solution(int[] nums) {
        ints = new int[3];
        check = new int[nums.length];
        check2 = new int[1001];
        DFS(0, 3, nums, 0);
        return result;
    }

    public static void DFS(int level, int n, int[] nums, int start) {
        if (level == n) {
            int sum = Arrays.stream(ints).sum();
            if (isPrime(sum) == 1) {
                result++;
            }
            return;
        }

        for (int i = start; i < nums.length; i++) {
            ints[level] = nums[i];
            DFS(level + 1, n, nums, i + 1);
        }
    }

    public static int isPrime(int n) {
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return 0;
            }
        }
        return 1;
    }

}
