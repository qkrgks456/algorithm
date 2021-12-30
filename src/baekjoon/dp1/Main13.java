package baekjoon.dp1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main13 {
    // 왼쪽 전깃줄이랑 오른쪽 전깃줄이 오름차순이 되면 안 겹쳐진다.
    // 안 겹쳐지는 애들 갯수 구해서 전체에서 빼주면 겹쳐지는 애들 최소 개수 나오겠지
    // 일단 왼쪽 전기줄 정렬 떄리고 오른쪽 증가수열 구하면 끝날듯 싶다
    // 개 어렵네 저걸 머릿속에서 어케 생각하누
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] ints = new int[n][2];
        for (int i = 0; i < n; i++) {
            ints[i][0] = scanner.nextInt();
            ints[i][1] = scanner.nextInt();
        }
        // 왼쪽 기준으로 정렬
        Arrays.sort(ints, (e1, e2) -> {
            if (e1[0] == e2[0]) {
                return e1[1] - e2[1];
            } else {
                return e1[0] - e2[0];
            }
        });
        // LIS 최장 수열 구하기
        ArrayList<Integer> list = new ArrayList<>();
        list.add(ints[0][1]);
        for (int i = 1; i < n; i++) {
            if (ints[i][1] > list.get(list.size() - 1)) {
                list.add(ints[i][1]);
            } else {
                for (int j = 0; j < list.size(); j++) {
                    if (ints[i][1] <= list.get(j)) {
                        list.set(j, ints[i][1]);
                        break;
                    }
                }
            }
        }
        System.out.println(n - list.size());
    }
}
