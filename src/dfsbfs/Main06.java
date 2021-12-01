package dfsbfs;

import java.util.Scanner;

public class Main06 {
    static int num;
    static int[] ch;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        num = scanner.nextInt();
        ch = new int[num + 1];
        DFS(1);
    }

    public static void DFS(int n) {
        if (n == num + 1) {
            for (int i = 0; i < ch.length; i++) {
                if (ch[i] == 1) {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        } else {
            ch[n] = 1;
            DFS(n + 1);
            ch[n] = 0;
            DFS(n + 1);
        }
    }
}
