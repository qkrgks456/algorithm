package studymylove2;

import java.util.Scanner;

public class Main01 {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // 변수
        String name = "";
        int kor, eng, math, total;
        float avg = 0.0f;
        String pass = "";
        String jang = "";
        String star = "";
        String level_kor = "", level_eng = "", level_math = "";
        String re = "";
        // 입력
        System.out.print("이름   입력: ");
        name = scanner.next();
        System.out.print("국어점수 입력: ");
        kor = scanner.nextInt();
        System.out.print("영어점수 입력: ");
        eng = scanner.nextInt();
        System.out.print("수학점수 입력: ");
        math = scanner.nextInt();
        // 처리
        total = process_total(kor, eng, math);
        avg = process_avg(total);
        pass = process_pass(avg, kor, eng, math, pass);
        jang = process_scholar(avg);
        star = process_star(avg);
        level_kor = process_level(kor);
        level_eng = process_level(eng);
        level_math = process_level(math);
        re = process_re(kor, eng, math);
        // 출력
        line1();
        process_show(name, kor, eng, math, total, avg, pass, jang, star);
        line2();
        process_show2(level_kor, level_eng, level_math);
        line2();
        process_show3(re);
        line2();
    }

    private static void process_show3(String re) {
        String[] strings = re.split(",");
        String korCheck = "-";
        String engCheck = "-";
        String mathCheck = "-";
        for (String s : strings) {
            if (s.equals("국어")) {
                korCheck = "O";
            } else if (s.equals("영어")) {
                engCheck = "O";
            } else if (s.equals("수학")) {
                mathCheck = "O";
            }
        }
        System.out.println("재시험     " + korCheck + "        " + engCheck + "        " + mathCheck);
    }

    private static void process_show2(String level_kor, String level_eng, String level_math) {
        System.out.println("            " + level_kor + "       " + level_eng + "       " + level_math);
    }

    private static void process_show(String name, int kor, int eng, int math, int total, float avg, String pass, String jang, String star) {
        if (isInteger(avg)) {
            System.out.println(name + "     " + kor + "     " + eng + "     "
                    + math + "     " + total + "     " + (int) avg + "     " + pass + "     " + jang + "     " + star);
        } else {
            System.out.println(name + "     " + kor + "     " + eng + "     "
                    + math + "     " + total + "     " + Math.round(avg * 100) / 100.0 + "     " + pass + "     " + jang + "     " + star);
        }

    }

    private static void line2() {
        System.out.println("================================================================================");
    }

    private static void line1() {
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("이름          국어      영어      수학      총점      평균      합격여부    장학생     랭킹");
        System.out.println("================================================================================");
    }

    private static String process_re(int kor, int eng, int math) {
        String result = "";
        if (kor < 40) {
            result += "국어,";
        }
        if (eng < 40) {
            result += "영어,";
        }
        if (math < 40) {
            result += "수학,";
        }
        return result;
    }

    private static String process_level(int num) {
        String result = "";
        if (num >= 90) {
            result = "수";
        } else if (num >= 80) {
            result = "우";
        } else if (num >= 70) {
            result = "미";
        } else if (num >= 60) {
            result = "양";
        } else {
            result = "가";
        }
        return result;
    }

    private static String process_star(float avg) {
        String star = "";
        int num = (int) avg;
        for (int i = 0; i < num / 10; i++) {
            star += "별";
        }
        return star;
    }

    private static String process_scholar(float avg) {
        if (avg >= 95) {
            return "장학생";
        }
        return "---";
    }

    private static String process_pass(float avg, int kor, int eng, int math, String pass) {
        pass = "합격";
        if (avg >= 60) {
            if (kor < 40) {
                pass = "재시험";
            }
            if (eng < 40) {
                pass = "재시험";
            }
            if (math < 40) {
                pass = "재시험";
            }
        } else {
            pass = "불합격";
        }
        return pass;
    }

    private static float process_avg(int total) {
        return (float) total / 3;
    }

    private static int process_total(int kor, int eng, int math) {
        return kor + eng + math;
    }

    // 정수 확인
    public static boolean isInteger(float number) {
        return Math.ceil(number) == Math.floor(number);
    }

}
