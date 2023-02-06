package programmers.problem.level2.level2_9;

import java.util.Arrays;

public class Solution8 {
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        return Math.max(findA(arrayA, arrayB), findA(arrayB, arrayA));
    }


    public int findA(int[] cur, int[] tar) {
        for (int i = cur[0]; i > 0; i--) {
            if (checkCur(cur, i) && checkTar(tar, i)) return i;
        }
        return 0;
    }


    public boolean checkCur(int[] ch, int i) {
        for (int n : ch) {
            if (n % i != 0) return false;
        }
        return true;
    }

    public boolean checkTar(int[] ch, int i) {
        for (int n : ch) {
            if (n % i == 0) return false;
        }
        return true;
    }

}
