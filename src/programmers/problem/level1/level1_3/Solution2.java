package programmers.problem.level1.level1_3;

import java.util.*;

public class Solution2 {
    public static int[] solution(int N, int[] stages) {
        List<Fail> list = new ArrayList<>();
        int[] answer = new int[N];
        int[] ints = new int[N + 2];
        int[] total = new int[N + 1];
        for (int i = 0; i < stages.length; i++) {
            ints[stages[i]]++;
        }

        // 이게 마지막 그건데
        total[N] = ints[N] + ints[N + 1];
        for (int i = N - 1; i >= 1; i--) {
            total[i] = ints[i] + total[i + 1];
        }
        for (int i = 1; i <= N; i++) {
            if (total[i] == 0) {
                list.add(new Fail(i, 0));
                continue;
            }
            list.add(new Fail(i, (double) ints[i] / total[i]));
        }
        Collections.sort(list, (o1, o2) -> {
            if (o1.fail < o2.fail) {
                return 1;
            } else if (o1.fail > o2.fail) {
                return -1;
            }
            if (o1.stage < o2.stage) {
                return -1;
            } else {
                return 1;
            }
        });
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).stage;
        }
        return answer;
    }
}

class Fail {
    int stage;
    double fail;

    public Fail(int stage, double fail) {
        this.stage = stage;
        this.fail = fail;
    }

    @Override
    public String toString() {
        return "Fail{" +
                "stage=" + stage +
                ", fail=" + fail +
                '}';
    }
}
