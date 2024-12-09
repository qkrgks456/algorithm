package baekjoon.v2.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10431 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < P; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int[] ints = new int[20];
            for (int j = 0; j < 20; j++) {
                ints[j] = Integer.parseInt(st.nextToken());
            }
            int count = 0;
            for (int j = 1; j < ints.length; j++) {
                boolean flag = false;
                int index = 0;
                // 가장 앞에 있는 학생 자리
                for (int k = j - 1; k >= 0; k--) {
                    if (ints[j] < ints[k]) {
                        flag = true;
                        index = k;
                    }
                }

                // 움직여라
                if (flag) {
                    int idx = j;
                    while (idx != index) {
                        int temp = ints[idx];
                        ints[idx] = ints[idx - 1];
                        ints[idx - 1] = temp;
                        count++;
                        idx--;
                    }
                }
            }
            sb.append(n).append(" ").append(count).append("\n");
        }
        System.out.println(sb);
    }
}
