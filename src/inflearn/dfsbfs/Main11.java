package inflearn.dfsbfs;

import java.util.ArrayList;
import java.util.Scanner;

public class Main11 {
    static int n1;
    static int result = 0;
    static ArrayList<ArrayList<Integer>> gra;
    static int[] ch;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        gra = new ArrayList<>();
        for (int i = 0; i <= n1; i++) {
            gra.add(new ArrayList<>());
        }
        ch = new int[n1 + 1];
        for (int i = 0; i < n2; i++) {
            int n3 = scanner.nextInt();
            int n4 = scanner.nextInt();
            gra.get(n3).add(n4);
        }
        ch[1] = 1;
        System.out.println(DFS(1));
    }

    public static int DFS(int n) {
        if (n == n1) {
            result++;
        } else {
            for (int num : gra.get(n)) {
                if (ch[num] == 0) {
                    ch[num] = 1;
                    DFS(num);
                    ch[num] = 0;
                }
            }
        }
        return result;
    }
}
