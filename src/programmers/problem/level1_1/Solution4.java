package programmers.problem.level1_1;

public class Solution4 {
    public int solution(int[] numbers) {
        int[] check = new int[10];
        for (int n : numbers) {
            check[n] = 1;
        }
        int sum = 0;
        for (int i = 0; i < check.length; i++) {
            if (check[i] == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
