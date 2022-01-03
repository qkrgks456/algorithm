package baekjoon.intCombi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main05 {
    // 아니 이걸 어케 암
    // A,B,C를 예시로 생각해보자
    // A%N = B%N , B%N = C%N
    // B%N - A%N = 0
    // C%N - B%N = 0
    // (B-A)%N = (C-B)%N
    // 를 통해서 인접한수 뺀것의 최대 공약수를 구하면 된단다 하 참나
    // 그러므로 정렬부터 하고
    // 무슨 골드5 문제는 장벽 개지려 ㅡ.ㅡ
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ints = new int[n];
        for (int i = 0; i < n; i++) {
            ints[i] = scanner.nextInt();
        }
        Arrays.sort(ints);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < ints.length - 1; i++) {
            list.add(ints[i + 1] - ints[i]);
        }
        int num = 0;
        // A,B,C,D의 최대공약수를 구하려면
        // A,B의 최대 공약수를 구하고
        // 그거랑 C랑 최대공약수를 구하고
        // 그후에 D랑 최대공약수를 구하자
        if (n > 2) {
            num = numReturn(list.get(0), list.get(1));
        } else {
            num = list.get(0);
        }
        for (int i = 2; i < list.size(); i++) {
            num = numReturn(num, list.get(i));
        }
        for (int i = 2; i <= num; i++) {
            if (num % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    // 두수의 최대 공약수 가져오는거
    public static int numReturn(int n1, int n2) {
        int num = 0;
        while (true) {
            num = n2 % n1;
            if (num == 0) {
                return n1;
            }
            n2 = n1;
            n1 = num;
        }
    }
}
