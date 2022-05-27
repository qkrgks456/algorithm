package mylove.studymylove3;

public class Score001 {
    String name;
    int kor;
    int eng;
    int math;
    int total;
    int aver;
    String p;
    String s;
    String rank;

    void process() {
        total = kor + eng + math;
        aver = total / 3;
    }

    void pass() {
        if (aver >= 60) {
            p = "합격";
            boolean check = false;
            if (kor < 40) {
                check = true;
            }
            if (eng < 40) {
                check = true;
            }
            if (math < 40) {
                check = true;
            }
            if (check) {
                p = "재시험";
            }
        } else {
            p = "불합격";
        }
    }

    void schola() {
        if (aver >= 95) {
            s = "장학생";
        }
    }

    void star() {
        int n = aver / 10;
        String s = "";
        for (int j = 0; j < n; j++) {
            s += "*";
        }
        rank = s;
    }

    void show() {
        process();
        pass();
        schola();
        star();
        System.out.println(":::::::::::::::::::::::::::::::::");
        System.out.println("이름      국어  영어  수학  평균   합격여부        장학생     랭킹");
        System.out.println(name + "      " + kor + "  " + eng + "  " + math + "  "
                + aver + "   " + p + "      " + s + "      " + rank);
    }

}
