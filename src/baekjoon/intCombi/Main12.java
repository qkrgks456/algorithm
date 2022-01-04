package baekjoon.intCombi;

import java.util.Scanner;

public class Main12 {
    // 됐고 저 승수를 어케 구하냐 이말인데 몫이 승수가 된다니 이건 기적 아니냐 ??
    // 솔직히 이걸 어케 생각하지 .. 에반디
    // 풀이는 생각했는데 승수 구하는게 저렇게 되네 ㅋㅋ 지린다
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextInt();
        long k = scanner.nextInt();
        int two = two(n) - two(n - k) - two(k);
        int five = five(n) - five(n - k) - five(k);
        System.out.println(Math.min(two, five));
    }

    // 2승수 구하기
    public static int two(long num) {
        int count = 0;
        while (num >= 2) {
            count += num / 2;
            num /= 2;
        }
        return count;
    }

    // 5승수 구하기
    public static int five(long num) {
        int count = 0;
        while (num >= 5) {
            count += num / 5;
            num /= 5;
        }
        return count;
    }
}
