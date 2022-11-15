package programmers.problem.level2.level2_5;

import java.util.ArrayList;
import java.util.List;

public class Solution9 {

    static String[] strings = {"A", "E", "I", "O", "U"};
    static List<String> list = new ArrayList<>();

    public int solution(String word) {
        DFS("");
        return list.indexOf(word);
    }

    public void DFS(String s) {
        if (s.length() > 5) {
            return;
        }
        list.add(s);
        for (int i = 0; i < strings.length; i++) {
            DFS(s + strings[i]);
        }
    }

}
