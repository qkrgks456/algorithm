package programmers.problem.level2.level2_4;

import java.util.ArrayList;
import java.util.List;

public class Solution4 {
    public int[] solution(String msg) {
        List<Integer> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("-");
        char ch = 65;
        for (int i = 1; i <= 26; i++) {
            list.add(String.valueOf(ch++));
        }
        for (int i = 0; i < msg.length(); i++) {
            for (int j = 0; j < msg.length() - i; j++) {
                String substring = msg.substring(i, msg.length() - j);
                if (list.contains(substring)) {
                    int index = list.indexOf(substring);
                    result.add(index);
                    if (msg.length() - j + 1 <= msg.length()) {
                        list.add(msg.substring(i, msg.length() - j + 1));
                    }
                    if (substring.length() > 1) {
                        i += substring.length() - 1;
                    }
                    break;
                }
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }
}
