package baekjoon.v1.step.binarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main07 {
    // 가장 긴 증가 부분 수열부터 기억 했는데 ㅅㅂ 아니 왜 자꾸 시간초과 뜨는거지 ??
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bufferedReader.readLine());
        int[] ints = new int[n];
        List<Integer> list = new ArrayList<>();
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        list.add(0);
        // 100만이면 시간 그냥 터져 버리쥬 이분탐색을 활용해라 ?
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
            if (list.get(list.size() - 1) < ints[i]) {
                list.add(ints[i]);
            } else {
                // 여기서 이분탐색 하면 된다
                int l = 0;
                int r = list.size() - 1;
                while (l < r) {
                    int mid = (l + r) / 2;
                    if (list.get(mid) < ints[i]) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                list.set(r, ints[i]);
            }
        }
        System.out.println(list.size() - 1);
    }
}
