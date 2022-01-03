package baekjoon.intCombi;

import java.util.Scanner;

public class Main10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int n1 = scanner.nextInt();
            String[][] strings = new String[n1][2];
            for (int j = 0; j < n1; j++) {
                String s = scanner.nextLine();
                String[] strings1 = s.split(" ");
                strings[j][0] = strings1[0];
                strings[j][1] = strings1[1];
            }
            // 여기서 부터 하면되는데 ..
        }
    }
}
