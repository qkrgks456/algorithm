package programmers.problem.level1_1;

public class Solution8 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] check = {6, 6, 5, 4, 3, 2, 1};
        int count = 0;
        int zeroCheck = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (lottos[i] == win_nums[j]) {
                    count++;
                }
            }
            if (lottos[i] == 0) {
                zeroCheck++;
            }
        }
        int max = count + zeroCheck;
        int min = count;
        int[] answer = {check[max],check[min]};
        return answer;
    }
}
