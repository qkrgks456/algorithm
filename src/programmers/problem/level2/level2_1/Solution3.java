package programmers.problem.level2.level2_1;

import java.util.Arrays;

public class Solution3 {

    public int solution(int[] A, int[] B) {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int num = B.length - 1;
        for (int i = 0; i < A.length; i++) {
            answer += A[i] * B[num];
            num--;
        }
        return answer;
    }
}
