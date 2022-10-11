package programmers.problem.level2.level2_2;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> list = new ArrayList<>();
        list.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() <= 1 || !stringCheck(words[i - 1], words[i]) || list.contains(words[i])) {
                answer[0] = i % n + 1;
                answer[1] = i / n + 1;
                return answer;
            }
            list.add(words[i]);
        }
        return answer;
    }

    public static boolean stringCheck(String s1, String s2) {
        return s1.charAt(s1.length() - 1) == s2.charAt(0);
    }
}
