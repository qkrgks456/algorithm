package baekjoon.v1.etc9;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main2503 {
    static int result = 0;
    static List<Quiz> list = new ArrayList<>();
    static int[] ch = new int[10];

    public static void main(String[] args) throws Exception {
        // 아 그러네 111 ~ 999 까지 포문 돌면서 조건 맞는지 확인하면 되네 ㅅㅂ
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        for (int j = 0; j < n; j++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int num = Integer.parseInt(stringTokenizer.nextToken());
            int strike = Integer.parseInt(stringTokenizer.nextToken());
            int ball = Integer.parseInt(stringTokenizer.nextToken());
            list.add(new Quiz(num, strike, ball));
        }
        String[] s1 = new String[3];
        DFS(0, s1);
        System.out.println(result);
    }

    public static void DFS(int level, String[] s1) {
        if (level == 3) {
            checkNum(s1);
            return;
        }

        for (int i = 1; i < 10; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                s1[level] = String.valueOf(i);
                DFS(level + 1, s1);
                ch[i] = 0;
            }
        }
    }

    public static void checkNum(String[] s1) {
        for (Quiz quiz : list) {
            String[] s = String.valueOf(quiz.num).split("");
            int count = 0;
            int count2 = 0;
            // 스트라이크 체크
            for (int j = 0; j < 3; j++) {
                if (s[j].equals(s1[j])) {
                    count++;
                }
            }
            // 볼체크
            if (s[0].equals(s1[1])) {
                count2++;
            }
            if (s[0].equals(s1[2])) {
                count2++;
            }
            if (s[1].equals(s1[0])) {
                count2++;
            }
            if (s[1].equals(s1[2])) {
                count2++;
            }
            if (s[2].equals(s1[0])) {
                count2++;
            }
            if (s[2].equals(s1[1])) {
                count2++;
            }

            if (quiz.strike != count) {
                return;
            }
            if (quiz.ball != count2) {
                return;
            }
        }
        result++;
    }
}

class Quiz {
    int num;
    int strike;
    int ball;

    public Quiz(int num, int strike, int ball) {
        this.num = num;
        this.strike = strike;
        this.ball = ball;
    }
}
