package dfsbfs;

import java.util.Scanner;

public class Main10 {
    static int n1;
    static int result = 0;
    static int[] ch;
    static int[][] ints;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strings = str.split(" ");
        n1 = Integer.parseInt(strings[0]);
        int n2 = Integer.parseInt(strings[1]);
        ch = new int[n1 + 1];
        ints = new int[n1 + 1][n1 + 1];
        for (int i = 0; i < n2; i++) {
            str = scanner.nextLine();
            strings = str.split(" ");
            int x = Integer.parseInt(strings[0]);
            int y = Integer.parseInt(strings[1]);
            ints[x][y] = 1;
        }
        System.out.println(DFS(1));
    }

    public static int DFS(int n) {
        if (n == n1) {
            result++;
        } else {
            ch[n] = 1;
            for (int i = 1; i <= n1; i++) {
                if (ints[n][i] == 1 && ch[i] == 0) {
                    DFS(i);
                    ch[n] = 0;
                }
            }
        }
        return result;
    }
}
