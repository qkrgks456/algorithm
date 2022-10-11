package programmers.problem.level2.level2_2;

public class Solution1 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        // 일단 약수 구하고
        int sum = brown + yellow;
        for (int i = 3; i <= sum; i++) {
            int check = sum / i;
            if (sum % i == 0 && check >= 3) {
                int col = Math.max(i, check);
                int row = Math.min(i, check);

                int center = (col - 2) * (row - 2);
                if (yellow == center) {
                    answer[0] = col;
                    answer[1] = row;
                    return answer;
                }
            }
        }
        return answer;
    }
}
