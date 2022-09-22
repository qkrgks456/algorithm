package programmers.kakao.test2022;

public class Solution4 {
    static int result = -1000;
    static int[] rion;
    static int[] res = {-1};

    public int[] solution(int n, int[] info) {
        rion = new int[11];
        DFS(n, 1, info);
        return res;
    }

    public static void DFS(int n, int cnt, int[] info) {
        if (cnt == n + 1) {
            int rionNum = 0;
            int apNum = 0;
            for (int i = 0; i < 11; i++) {
                if (info[i] != 0 || rion[i] != 0) {
                    if (rion[i] > info[i]) {
                        rionNum += 10 - i;
                    } else {
                        apNum += 10 - i;
                    }
                }
            }
            if (rionNum > apNum) {
                if (result <= rionNum - apNum) {
                    result = rionNum - apNum;
                    res = rion.clone();
                }
            }
            return;
        }
        for (int i = 0; i < 11 && rion[i] <= info[i]; i++) {
            rion[i]++;
            DFS(n, cnt + 1, info);
            rion[i]--;
        }
    }
}
