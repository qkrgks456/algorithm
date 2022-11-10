package programmers.problem.level1.level1_8;

public class Solution8 {
    public String solution(int[] food) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0");
        for (int i = food.length - 1; i >= 0; i--) {
            int num = food[i];
            if (num == 1) continue;
            if (num % 2 != 0) {
                num -= 1;
            }
            for (int j = 0; j < num / 2; j++) {
                stringBuilder.insert(0, i);
                stringBuilder.append(i);
            }
        }
        return stringBuilder.toString();
    }
}
