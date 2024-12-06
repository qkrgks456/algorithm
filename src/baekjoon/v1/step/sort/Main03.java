package baekjoon.v1.step.sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main03 {
    // 카운팅 정렬
    // https://www.cs.miami.edu/home/burt/learning/Csc517.091/workbook/countingsort.html
    // 여기 보고 참고하자
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = bufferedReader.readLine();
        int[] ints = new int[10001];
        int[] aArray = new int[Integer.parseInt(str)];
        int[] bArray = new int[Integer.parseInt(str)];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < Integer.parseInt(str); i++) {
            int t = Integer.parseInt(bufferedReader.readLine());
            aArray[i] = t;
            ints[t]++;
            if (max < t) {
                max = t;
            }
        }
        for (int i = 1; i <= max - 1; i++) {
            ints[i + 1] += ints[i];
        }
        for (int i = aArray.length - 1; i >= 0; i--) {
            bArray[ints[aArray[i]] - 1] = aArray[i];
            ints[aArray[i]] -= 1;
        }
        for (int n : bArray) {
            bufferedWriter.write(String.valueOf(n));
            bufferedWriter.write("\n");
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }
}
