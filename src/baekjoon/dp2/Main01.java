package baekjoon.dp2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main01 {
    static int num;

    // 점화식도 어렵고 구현도 어렵고 이건아니지
    // 진짜 레전드 풀이보고도 어려운문제 정답률 높은거 말도 안됨
    // 풀이봐도 난해하다
    // 점화식을 보면
    // 1일때
    // dp[i][i] = 0
    // 2일때
    // dp[i][i+1] = val[i] + val[i+1]
    // 3일때
    // dp[i][j] = dp[i][k] + dp[k+1][j] + sum[val(i~j)]
    // 못품
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < n; i++) {
            num = Integer.parseInt(bufferedReader.readLine());
            String s = bufferedReader.readLine();
            String[] strings = s.split(" ");
            int[] ints = new int[num];
            int[][] check = new int[502][502];
            int[] sum = new int[num];
            for (int j = 0; j < num; j++) {
                ints[j] = Integer.parseInt(strings[j]);
            }
            // 총합 미리 DP로 구해서 담아놓자 ㅇㅋ?
            sum[0] = ints[0];
            for (int j = 1; j < num; j++) {
                sum[j] = ints[j] + sum[j - 1];
            }

            // 인접한 애들 더한 값
            for (int j = 0; j < num - 1; j++) {
                check[j][j + 1] = ints[j] + ints[j + 1];
            }

            // 이해불가
            for (int j = 2; j < num; j++) {
                for (int k = 0; k + j < num; k++) {
                    for (int l = k; l < k + j; l++) {
                        if (check[k][k + j] == 0) {
                            check[k][k + j] = check[k][l] + check[l + 1][k + j] + sumCheck(sum, k, k + j);
                        } else {
                            check[k][k + j] = Math.min(check[k][k + j], check[k][l] + check[l + 1][k + j] + sumCheck(sum, k, k + j));
                        }
                    }
                }
            }

            for (int j = 0; j < num; j++) {
                for (int k = 0; k < num; k++) {
                    System.out.print(check[j][k] + " ");
                }
                System.out.println();
            }
            stringBuilder.append(check[0][num - 1] + "\n");
        }
        System.out.println(stringBuilder);
    }

    public static int sumCheck(int[] sums, int start, int end) {
        if (start == 0) {
            return sums[end];
        } else {
            return sums[end] - sums[start - 1];
        }
    }

}
