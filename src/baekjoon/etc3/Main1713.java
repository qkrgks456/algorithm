package baekjoon.etc3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main1713 {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());
        int[] member = new int[M];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) {
            member[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        List<Member> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            if (list.size() == N) {
                boolean checks = true;
                // 최소값 구하기
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < list.size(); j++) {
                    if (min > list.get(j).count) {
                        min = list.get(j).count;
                    }
                }
                // 같은값일경우 실행 안함
                if (overlap(list, member[i])) {
                    // 최소값 2개이상이지 확인
                    int check = 0;
                    int idx = 0;
                    for (int j = 0; j < list.size(); j++) {
                        if (min == list.get(j).count) {
                            idx = j;
                            check++;
                        }
                    }
                    // 2개면 오래된놈 제거 아니면 최소값 제거
                    if (check == 2) {
                        list.remove(0);
                        list.add(new Member(member[i], 1));
                    } else {
                        list.remove(idx);
                        list.add(new Member(member[i], 1));
                    }
                }
            } else {
                // 중복시 실행 안함
                if (overlap(list, member[i])) {
                    list.add(new Member(member[i], 1));
                }
            }
        }
        // 마무리 정렬까지
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i).num;
        }
        Arrays.sort(result);
        for (int n : result) {
            System.out.print(n + " ");
        }
    }

    // 중복체크
    public static boolean overlap(List<Member> list, int memberNum) {
        boolean checks = true;
        for (int j = 0; j < list.size(); j++) {
            // 같은값이면 플러스
            if (memberNum == list.get(j).num) {
                checks = false;
                int count = list.get(j).count;
                int num = list.get(j).num;
                list.remove(j);
                list.add(new Member(num, count + 1));
            }
        }
        return checks;
    }
}

class Member {
    int num;
    int count;

    public Member(int num, int count) {
        this.num = num;
        this.count = count;
    }
}