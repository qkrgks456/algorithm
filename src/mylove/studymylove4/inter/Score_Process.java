package mylove.studymylove4.inter;

// 왜 여러개를 만든지 모르곘습니다
public class Score_Process implements ScoreProcess {
    @Override
    public String exec_jang(double aver) {
        String s = "";
        if (aver >= 95) {
            s = "장학생";
        } else {
            s = "";
        }
        return s;
    }

    @Override
    public String star(double aver) {
        String s = "";
        for (int i = 0; i < aver / 10; i++) {
            s += "*";
        }
        return s;
    }

    @Override
    public String exec(double aver) {
        String s = "";
        if (aver >= 60) {
            s = "합격";
        } else {
            s = "불합격";
        }
        return s;
    }

    @Override
    public int total(int kor, int eng, int math) {
        return kor + eng + math;
    }

    @Override
    public double avg(int total) {
        return total / 3;
    }
}
