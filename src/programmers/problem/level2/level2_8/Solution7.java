package programmers.problem.level2.level2_8;

public class Solution7 {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static String[][] strings;

    public int[] solution(String[][] places) {
        int[] ints = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            // 배열 채우기
            strings = new String[5][5];
            for (int j = 0; j < places[i].length; j++) {
                String[] split = places[i][j].split("");
                for (int k = 0; k < split.length; k++) {
                    strings[j][k] = split[k];
                }
            }
            // 반대로 생각해서 O일 경우랑 P일 경우만 생각하면 간단함
            int nx, ny;
            ints[i] = 1;
            for (int j = 0; j < strings.length; j++) {
                for (int k = 0; k < strings[i].length; k++) {
                    if (strings[j][k].equals("O")) {
                        int count = 0;
                        for (int l = 0; l < 4; l++) {
                            nx = dx[l] + j;
                            ny = dy[l] + k;
                            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && strings[nx][ny].equals("P")) {
                                count++;
                            }
                        }
                        if (count >= 2) ints[i] = 0;
                    } else if (strings[j][k].equals("P")) {
                        for (int l = 0; l < 4; l++) {
                            nx = dx[l] + j;
                            ny = dy[l] + k;
                            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && strings[nx][ny].equals("P")) {
                                ints[i] = 0;
                            }
                        }
                    }
                }
            }
        }
        return ints;
    }

}
