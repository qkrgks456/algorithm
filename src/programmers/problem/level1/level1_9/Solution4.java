package programmers.problem.level1.level1_9;

public class Solution4 {

    public int solution(String t, String p) {
        int size = p.length();
        long n = Long.parseLong(p);
        int result = 0;
        for (int i = 0; i <= t.length() - size; i++) {
            long n1 = Long.parseLong(t.substring(i, size + i));
            if (n1 <= n) result++;
        }
        return result;
    }

}
