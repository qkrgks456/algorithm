package programmers.problem.level2.level2_6;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public long[] solution(long[] numbers) {
        List<Long> list = new ArrayList<>();
        for (long number : numbers) {
            if (number % 2 == 0) {
                list.add(number + 1);
            } else {
                String check = Long.toString(number, 2);
                int idx = check.lastIndexOf("0");
                if (idx != -1) {
                    check = check.substring(0, idx) + "10" + check.substring(idx + 2);
                    list.add(Long.parseLong(check, 2));
                } else {
                    check = "10" + check.substring(1);
                    list.add(Long.parseLong(check, 2));
                }
            }
        }
        return list.stream().mapToLong(i -> i).toArray();
    }


}
