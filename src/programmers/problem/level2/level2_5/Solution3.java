package programmers.problem.level2.level2_5;

import java.awt.*;
import java.util.HashSet;

public class Solution3 {
    public int solution(int m, int n, String[] board) {
        String[][] strings = new String[m][n];
        for (int i = 0; i < strings.length; i++) {
            String[] boards = board[i].split("");
            for (int j = 0; j < strings[0].length; j++) {
                strings[i][j] = boards[j];
            }
        }
        int result = 0;
        while (true) {
            // 4개인 애들 리스트에 담기
            HashSet<Point> set = new HashSet<>();
            for (int i = 0; i < strings.length - 1; i++) {
                for (int j = 0; j < strings[i].length - 1; j++) {
                    String s = strings[i][j];
                    String s1 = strings[i][j + 1];
                    String s2 = strings[i + 1][j];
                    String s3 = strings[i + 1][j + 1];
                    if (s.equals(s1) && s1.equals(s2) && s2.equals(s3) && !s.equals("")) {
                        set.add(new Point(i, j));
                        set.add(new Point(i, j + 1));
                        set.add(new Point(i + 1, j));
                        set.add(new Point(i + 1, j + 1));
                    }
                }
            }
            // 아얘 지울게 없으면 멈추기
            if (set.isEmpty()) break;
            // 4개인 애들 비우기
            for (Point point : set) {
                strings[point.x][point.y] = "";
                result++;
            }

            // 아래로 움직여
            while (true) {
                boolean check = true;
                for (int i = 0; i < strings.length - 1; i++) {
                    for (int j = 0; j < strings[i].length; j++) {
                        if (!strings[i][j].equals("") && strings[i + 1][j].equals("")) {
                            check = false;
                            String temp = strings[i][j];
                            strings[i][j] = "";
                            strings[i + 1][j] = temp;
                        }
                    }
                }
                if (check) break;
            }
        }
        return result;
    }
}

