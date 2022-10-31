package programmers.problem.level1.level1_8;

import java.util.Arrays;

public class Solution5 {

    static int[] third = new int[3];
    static int[] num;
    static int[] check;
    static int result = 0;

    public static int solution(int[] number) {
        num = number.clone();
        check = new int[number.length];
        DFS(0, 0, 3);
        return result;
    }


    public static void DFS(int start, int count, int level) {
        if (count == level) {
            if (Arrays.stream(third).sum() == 0) result++;
            return;
        }
        for (int i = start; i < num.length; i++) {
            if (check[i] == 0) {
                check[i] = 1;
                third[count] = num[i];
                DFS(i + 1, count + 1, level);
                check[i] = 0;
            }
        }

    }

}
