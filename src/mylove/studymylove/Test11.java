package mylove.studymylove;

public class Test11 {
    public static void main(String[] args) {
        int[][] score = {
                {100, 100, 100},
                {20, 20, 20},
                {30, 30, 30},
                {40, 40, 40},
                {50, 50, 50}
        };

        // 대입
        // 기존 이차원배열 전체 탐색
        String s = "";
        for (int i = 0; i < score.length; i++) {
            int sum = 0;
            for (int j = 0; j < score[i].length; j++) {
                sum += score[i][j];
                s += score[i][j] + "\t";
            }
            s += sum + "\n";
        }
        // 세로로 탐색 ex) 100 -> 20 -> 30 -> 40 -> 50
        int result = 0;
        for (int i = 0; i < score[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < score.length; j++) {
                sum += score[j][i];
            }
            result += sum;
            s += sum + "\t"; // 240
        }
        s += result; // 720
        //출력
        System.out.print(s);
    }
}
