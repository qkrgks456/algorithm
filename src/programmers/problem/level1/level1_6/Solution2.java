package programmers.problem.level1.level1_6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2 {
    public int[] solution(int[] arr) {
        List<Integer> list = Arrays.stream(arr).boxed().sorted().collect(Collectors.toList());
        List<Integer> list2 = Arrays.stream(arr).boxed().collect(Collectors.toList());
        list2.remove(list.get(0));
        if (list2.size() == 0) list2.add(-1);
        return list2.stream().mapToInt(i -> i).toArray();
    }
}
