package programmers.problem.level2.level2_7;

public class Solution2 {
    static StringBuilder sb = new StringBuilder();

    public String solution(int n) {
        DFS(n);
        return sb.toString();
    }

    public void DFS(int n) {
        if (n == 1) {
            sb.append("1");
        } else if (n == 2) {
            sb.append("2");
        } else if (n == 3 || n == 0) {
            sb.append("4");
        } else {
            DFS((n - 1) / 3);
            DFS(n % 3);
        }
    }
}
