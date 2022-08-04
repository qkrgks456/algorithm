package baekjoon.etc9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2503 {
    public static void main(String[] args) throws Exception {
        // 아 그러네 111 ~ 999 까지 포문 돌면서 조건 맞는지 확인하면 되네 ㅅㅂ
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        loop:
        for (int i = 111; i <= 999; i++) {
            for (int j = 0; j < n; j++) {
                StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                String[] strings = stringTokenizer.nextToken().split("");
                int strike = Integer.parseInt(stringTokenizer.nextToken());
                int ball = Integer.parseInt(stringTokenizer.nextToken());
                // 스트라이크 체크
                if (strike != 0) {
                    int count = 0;
                    for (String s : strings) {
                        String checkStr = String.valueOf(i);
                        if (checkStr.contains(s)) count++;
                    }
                    if (count != strike) {
                        continue loop;
                    }
                }
                // 볼체크
                if (ball != 0) {

                }
            }
        }
    }
}
