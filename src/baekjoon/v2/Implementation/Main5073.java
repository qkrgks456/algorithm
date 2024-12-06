package baekjoon.v2.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main5073 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(stringTokenizer.nextToken());
            int n2 = Integer.parseInt(stringTokenizer.nextToken());
            int n3 = Integer.parseInt(stringTokenizer.nextToken());
            if (n1 == 0 && n2 == 0 && n3 == 0) break;
            // 조건을 만족 못하는 경우
            if (n1 >= n2 + n3) {
                sb.append("Invalid").append("\n");
                continue;
            }

            if (n2 >= n1 + n3) {
                sb.append("Invalid").append("\n");
                continue;
            }

            if (n3 >= n1 + n2) {
                sb.append("Invalid").append("\n");
                continue;
            }

            // 조건은 만족됨
            if (n1 == n2 && n2 == n3) {
                sb.append("Equilateral").append("\n");
            } else if (n1 == n2 || n2 == n3 || n1 == n3) {
                sb.append("Isosceles").append("\n");
            } else {
                sb.append("Scalene").append("\n");
            }
        }
        System.out.println(sb);
    }
}
