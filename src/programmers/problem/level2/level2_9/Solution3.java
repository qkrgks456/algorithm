package programmers.problem.level2.level2_9;

import java.util.HashSet;

public class Solution3 {

    public int solution(int x, int y, int n) {
        int count = 0;
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2;
        set.add(x);

        while (!set.isEmpty()) {
            set2 = new HashSet<>();
            if (set.contains(y)) return count;
            for (int num : set) {
                int n1 = num + n;
                int n2 = num * 2;
                int n3 = num * 3;
                if (n1 <= y) set2.add(n1);
                if (n2 <= y) set2.add(n2);
                if (n3 <= y) set2.add(n3);
            }
            set = set2;
            count++;
        }
        return -1;
    }
}
