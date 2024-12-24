package baekjoon.v2.Implementation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1205 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken()); // 현재 기록된 점수 개수
        int point = Integer.parseInt(stringTokenizer.nextToken()); // 추가될 점수
        int p = Integer.parseInt(stringTokenizer.nextToken()); // 최대 기록 가능한 점수 개수
        if (n == 0) {
            System.out.println(1);
            return;
        }
        int[] ints = new int[p]; // 점수 배열
        stringTokenizer = new StringTokenizer(br.readLine());

        // 기존 점수 입력
        for (int i = 0; i < n; i++) {
            ints[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        // 리스트가 꽉 차지 않았을 경우
        if (n < p) {
            ints[n] = point; // 새로운 점수 삽입
            arrayChange(n, ints); // 정렬
            rank(ints, point, n + 1); // 순위 출력 (n + 1로 전달)
        }
        // 리스트가 꽉 찼을 경우
        else {
            if (ints[p - 1] < point) { // 새로운 점수가 가장 작은 값보다 클 경우
                ints[p - 1] = point; // 가장 작은 점수에 삽입
                arrayChange(p - 1, ints); // 정렬
                rank(ints, point, p); // 순위 출력
            } else {
                System.out.println(-1); // 삽입할 수 없으면 -1 출력
            }
        }
    }

    // 점수 삽입 후 정렬하는 메서드 (내림차순)
    public static void arrayChange(int index, int[] ints) {
        while (index > 0 && ints[index - 1] < ints[index]) {
            int temp = ints[index - 1];
            ints[index - 1] = ints[index];
            ints[index] = temp;
            index--;
        }
    }

    // 주어진 점수의 순위를 출력하는 메서드
    public static void rank(int[] ints, int point, int n) {
        for (int i = 0; i < n; i++) {
            if (ints[i] == point) {
                System.out.println(i + 1); // 순위는 1부터 시작
                break;
            }
        }
    }
}
