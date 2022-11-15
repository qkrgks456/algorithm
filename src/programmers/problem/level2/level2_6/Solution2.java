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
                int size = 0;
                String check = toBinary(number, 50);
                for (int i = check.length() - 1; i >= 0; i--) {
                    if (check.charAt(i) == '0') {
                        size = check.length() - 1 - i;
                        break;
                    }
                }

                System.out.println(size);
            }
        }
        return list.stream().mapToLong(i -> i).toArray();
    }

    public static String toBinary(long n, int length) {
        StringBuilder binary = new StringBuilder();
        for (long i = (1L << length - 1); i > 0; i = i / 2) {
            binary.append((n & i) != 0 ? "1" : "0");
        }
        return binary.toString();
    }

}
