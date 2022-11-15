package programmers.problem.level2.level2_5;

import java.util.HashSet;
import java.util.Set;

public class Solution8 {

    public int solution(int[] elements) {
        int[] ch = new int[elements.length * 3];
        int size = elements.length;
        for (int i = 0; i < 3; i++) {
            for (int j = size * i, n = 0; j < size * (i + 1); j++, n++) {
                if (n == size) n = 0;
                ch[j] = elements[n];
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= size; i++) {
            int left = 0;
            int right = i;
            int sum = 0;
            for (int j = left; j < right; j++) {
                sum += ch[j];
                set.add(sum);
            }
            while (right < ch.length) {
                sum -= ch[left];
                sum += ch[right];
                set.add(sum);
                left++;
                right++;
            }
        }
        return set.size();
    }

}
