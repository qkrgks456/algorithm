package baekjoon.v1.etc5;

import java.util.Scanner;

public class Main1107 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int[] ints = new int[10];
        for (int i = 0; i < M; i++) {
            int num = scanner.nextInt();
            ints[num] = 1;
        }
        // 초기화 해줘야함 만약에 100자리 번수나 10자리 번수에서 번호 고장나 있으면 처음에 뺴줘야 최소값으로 됨
        int result = Math.abs(N - 100);
        for (int i = 0; i <= 999999; i++) {
            // 일단 만들 수 있는 수인지 확인하자
            // 고장 난 버튼을 누른다면 ?
            String s = String.valueOf(i);
            boolean check = true;
            for (int j = 0; j < s.length(); j++) {
                // 문자 '0' 을 빼줘야 int랑 비교가능
                // 고장난 버튼 이용하면 버리자
                if (ints[s.charAt(j) - '0'] == 1) {
                    check = false;
                    break;
                }
            }
            // 고장나지 않은 버튼으로 이루어져 있다면
            if (check) {
                result = Math.min(Math.abs(N - i) + s.length(), result);
            }
        }
        System.out.println(result);
    }

}
