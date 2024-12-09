package baekjoon.v2.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main8979 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        List<Medal> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            Medal medal = new Medal();
            medal.number = Integer.parseInt(st.nextToken());
            medal.gold = Integer.parseInt(st.nextToken());
            medal.silver = Integer.parseInt(st.nextToken());
            medal.bronze = Integer.parseInt(st.nextToken());
            list.add(medal);
        }
        list.sort((o1, o2) -> {
            if (o1.gold != o2.gold) {
                return Integer.compare(o2.gold, o1.gold); // 금메달 기준 내림차순
            }
            if (o1.silver != o2.silver) {
                return Integer.compare(o2.silver, o1.silver); // 은메달 기준 내림차순
            }
            return Integer.compare(o2.bronze, o1.bronze); // 동메달 기준 내림차순
        });

        // 현재 등수
        int rank = 1;
        Medal first = list.get(0);
        first.rank = rank;
        for (int i = 1; i < n; i++) {
            // 동일성 여부 체크
            Medal curMedal = list.get(i);
            Medal beforeMedal = list.get(i - 1);
            if (curMedal.gold == beforeMedal.gold
                    && curMedal.silver == beforeMedal.silver
                    && curMedal.bronze == beforeMedal.bronze) {
                curMedal.rank = beforeMedal.rank;
            } else {
                curMedal.rank = i + 1;
            }
        }

        for (Medal medal : list) {
            if (medal.number == k) {
                System.out.println(medal.rank);
                break;
            }
        }


    }
}


class Medal {
    int number;
    int gold;
    int silver;
    int bronze;
    int rank;

    @Override
    public String toString() {
        return "Medal{" +
                "number=" + number +
                ", gold=" + gold +
                ", silver=" + silver +
                ", bronze=" + bronze +
                '}';
    }
}
