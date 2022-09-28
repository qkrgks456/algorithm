package programmers;

import java.util.Arrays;

public class Main {

    static int[] ints = {1, 2, 3, 4, 5};
    static int[] check = new int[5];
    static int[] result = new int[3];
    static int n = 3;

    public static void main(String[] args) {
        DFS(0, 0);
    }

    public static void DFS(int level, int start) {
        if (level == n) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = start; i < 5; i++) {
            result[level] = ints[i];
            DFS(level + 1, i + 1);
        }
    }
}

