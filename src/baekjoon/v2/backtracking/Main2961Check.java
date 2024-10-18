package baekjoon.v2.backtracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2961Check {
    static int n, result;
    static int[] sArray, bArray;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bufferedReader.readLine());
        sArray = new int[n];
        bArray = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int s = Integer.parseInt(stringTokenizer.nextToken());
            int b = Integer.parseInt(stringTokenizer.nextToken());
            sArray[i] = s;
            bArray[i] = b;
        }
        result = Integer.MAX_VALUE;
        DFS(0, 1, 0, 0);
        System.out.println(result);
    }

    // 조합 뽑는법이 아래처럼도 가능하다 .. 재귀가 역시 제일 뭣같네
    public static void DFS(int index, int sTotal, int bTotal, int count) {
        if (index == n) {
            if (count > 0) {
                result = Math.min(result, Math.abs(sTotal - bTotal));
            }
            return;
        }

        // 재료를 선택하는 경우
        DFS(index + 1, sTotal * sArray[index], bTotal + bArray[index], count + 1);

        // 재료를 선택하지 않는 경우
        DFS(index + 1, sTotal, bTotal, count);
    }
}
