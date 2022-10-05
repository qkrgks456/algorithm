package programmers.problem.level1.level1_2;

import java.util.Arrays;

public class Solution6 {
    public static void main(String[] args) {
        System.out.println(solution(5, new int[]{4, 2}, new int[]{3, 5}));
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        for (int i = 0; i < reserve.length; i++) {
            for (int j = 0; j < lost.length; j++) {
                if (reserve[i] == lost[j]) {
                    lost[j] = 0;
                    reserve[i] = 0;
                }
            }
        }
        Arrays.sort(reserve);
        Arrays.sort(lost);
        for (int i = 0; i < reserve.length; i++) {
            if(reserve[i] == 0) continue;
            int n1 = reserve[i] - 1;
            int n2 = reserve[i] + 1;
            for (int j = 0; j < lost.length; j++) {
                if(lost[j] == 0) continue;
                if (n1 == lost[j] || n2 == lost[j]) {
                    lost[j] = 0;
                    break;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] > 0) {
                count++;
            }
        }
        return n - count;
    }
}
