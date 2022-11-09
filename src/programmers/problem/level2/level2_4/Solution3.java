package programmers.problem.level2.level2_4;

public class Solution3 {

    static int result = 0;
    static int check;

    public static int solution(int[] numbers, int target) {
        check = target;
        DFS(0, 0, numbers);
        return result;
    }

    public static void DFS(int num, int n, int[] ints) {
        if (n == ints.length) {
            if (num == check) {
                result++;
            }
            return;
        }
        DFS(num + ints[n], n + 1, ints);
        DFS(num - ints[n], n + 1, ints);
    }
}
