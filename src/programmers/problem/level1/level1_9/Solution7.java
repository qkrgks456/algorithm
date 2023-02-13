package programmers.problem.level1.level1_9;

public class Solution7 {
    public String solution(String s, String skip, int index) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int n = index;
            int ch = s.charAt(i);
            while (n != 0) {
                ch++;
                if (ch == 123) ch = 97;
                String str = String.valueOf((char) ch);
                if (!skip.contains(str)) n--;
            }
            result.append((char) ch);
        }
        return result.toString();
    }
}
