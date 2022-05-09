package studymylove;

import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("이름 입력>");
        String name = scanner.next();
        int kor = 0, eng = 0, math = 0, tot = 0;
        String levelCheck, goodCheck, sucCheck = "";
        int num = 0;
        float avg;
        // 입력받기
        for (; ; ) {
            if (num == 0) {
                System.out.println("국어점수 입력>");
                kor = scanner.nextInt();
                if (kor < 0 || kor > 100) {
                    continue;
                }
                num = 1;
            } else if (num == 1) {
                System.out.println("영어점수 입력>");
                eng = scanner.nextInt();
                if (eng < 0 || eng > 100) {
                    continue;
                }
                num = 2;
            } else {
                System.out.println("수학점수 입력>");
                math = scanner.nextInt();
                if (math < 0 || math > 100) {
                    continue;
                }
                break;
            }
        }
        // 총점 구하기
        tot = kor + eng + math;
        // 평균 구하기
        avg = (float) tot / 3;
        // 재시험 확인
        // 0 국어 1 영어 2 수학
        String[] check = new String[3];
        boolean checks = false;
        if (kor < 40) {
            check[0] = "kor";
            checks = true;
        }
        if (eng < 40) {
            check[1] = "eng";
            checks = true;
        }
        if (math < 40) {
            check[2] = "math";
            checks = true;
        }
        if (checks) {
            String s = "";
            for (int i = 0; i < 3; i++) {
                if (check[i] != null) {
                    s += check[i] + " ";
                }
            }
            System.out.println(s + "재시험");
        }
        // 별 만들기
        String result = "";
        int nums = (int) Math.floor(avg) / 10;
        for (int i = 0; i < nums; i++) {
            // 맥북 한자 몬하겠어 별로 바꿔줘 ㅋㅋ
            result += "별";
        }
        String korCheck = kor >= 90 ? "수" : kor >= 80 ? "우" : kor >= 70 ? "미" : kor >= 60 ? "양" : "가";
        String engCheck = eng >= 90 ? "수" : eng >= 80 ? "우" : eng >= 70 ? "미" : eng >= 60 ? "양" : "가";
        String mathCheck = math >= 90 ? "수" : math >= 80 ? "우" : math >= 70 ? "미" : math >= 60 ? "양" : "가";
        goodCheck = avg >= 95 ? "장학생" : "";
        sucCheck = avg >= 60 ? "합격" : "불합격";
        System.out.println("==================================================================================");
        System.out.println("학번      국어      영어      수학      총점      평균      합격여부        레벨      장학생");
        System.out.println("==================================================================================");
        System.out.println(name + "     " + kor + "(" + korCheck + ")" + "     " + eng + "(" + engCheck + ")" + "     " + math + "(" + mathCheck + ")"
                + "        " + tot + "     "
                + (float) Math.round(avg * 100) / 100 + "        " + sucCheck + "      " + result + "      " + goodCheck);
        System.out.println("==================================================================================");
    }
}
