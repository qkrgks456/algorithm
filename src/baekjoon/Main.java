package baekjoon;

public class Main {
    public static void main(String[] args) throws Exception {
        String a = "ABBBDAAA";
        String b = "BADABBDBA";

        int[][] dp = new int[a.length()][b.length()];
        for (int i = 1; i < a.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i < b.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < a.length(); i++) {
            for (int j = 1; j < b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 삽입
                    int insert = dp[i - 1][j];
                    // 삭제
                    int delete = dp[i][j - 1];
                    dp[i][j] = Math.min(insert, delete) + 1;
                }
            }
        }
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }

    }
}