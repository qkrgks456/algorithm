package programmers.problem.level1.level1_3;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {
    public int[] solution(int[] answers) {
        int[] n1 = new int[10000];
        int[] n2 = new int[10000];
        int[] n3 = new int[10000];
        int num = 1;
        int num2 = 1;
        int num3 = 3;
        boolean check = true;
        int check3 = 0;
        for (int i = 0; i < 10000; i++) {
            // 1번
            if (num == 6) num = 1;
            n1[i] = num;
            num++;
            // 2번
            if (check) {
                n2[i] = 2;
            } else {
                if (num2 == 6) num2 = 1;
                n2[i] = num2;
                if (num2 == 1) {
                    num2 += 2;
                } else {
                    num2 += 1;
                }
            }
            check = !check;
            // 3번
            if (check3 == 2) {
                check3 = 0;
                switch (num3) {
                    case 3:
                        num3 = 1;
                        break;
                    case 1:
                        num3 = 2;
                        break;
                    case 2:
                        num3 = 4;
                        break;
                    case 4:
                        num3 = 5;
                        break;
                    case 5:
                        num3 = 3;
                        break;
                }
            }
            n3[i] = num3;
            check3++;
        }
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        for (int i = 0; i < answers.length; i++) {
            if (n1[i] == answers[i]) count1++;
            if (n2[i] == answers[i]) count2++;
            if (n3[i] == answers[i]) count3++;
        }
        int max = Math.max(count1, Math.max(count2, count3));
        List<Integer> list = new ArrayList<>();
        if (max == count1) {
            list.add(1);
        }
        if (max == count2) {
            list.add(2);
        }
        if (max == count3) {
            list.add(3);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
