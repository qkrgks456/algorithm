package baekjoon.etc3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main1713 {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        List<Member> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int member = Integer.parseInt(stringTokenizer.nextToken());
            // 중복이 안됐으면
            boolean checks = false;
            for (Member members : list) {
                // 같은값이면 플러스
                if (member == members.num) {
                    checks = true;
                    members.count++;
                    break;
                }
            }
            // 중복시 건너띔
            if (!checks) {
                // 사이즈 꽉 찼을떄
                if (list.size() == N) {
                    // 최소값중에 오래된놈 혹은 최소값 제거
                    list.remove(0);
                    list.add(new Member(member, 1, i));
                } else {
                    // 사이즈가 남을때
                    list.add(new Member(member, 1, i));
                }
            }
            Collections.sort(list);
        }
        Collections.sort(list, (o1, o2) -> o1.num - o2.num);
        // 마무리 정렬까지
        for (Member members : list) {
            System.out.print(members.num + " ");
        }
    }
}

class Member implements Comparable<Member> {
    int num, count, day;

    public Member(int num, int count, int day) {
        this.num = num;
        this.count = count;
        this.day = day;
    }

    @Override
    public int compareTo(Member o) {
        if (this.count == o.count) {
            return this.day - o.day;
        }
        return this.count - o.count;
    }
}