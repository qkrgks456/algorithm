package baekjoon.etc11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main10812 {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());
        List<Integer> list = new ArrayList<>();
        // 1부터 10까지 채우기
        list.add(0);
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int I = Integer.parseInt(stringTokenizer.nextToken());
            int J = Integer.parseInt(stringTokenizer.nextToken());
            int K = Integer.parseInt(stringTokenizer.nextToken());
            List<Integer> check = new ArrayList<>();
            int num = J - K;
            while (num != -1) {
                check.add(list.get(K));
                list.remove(K);
                num--;
            }
            for (int j = check.size() - 1; j >= 0; j--) {
                list.add(I, check.get(j));
            }
        }

        list.remove((Integer) 0);
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : list) {
            stringBuilder.append(integer).append(" ");
        }
        System.out.println(stringBuilder);
    }
}

