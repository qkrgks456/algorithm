package studymylove3;


public class Test {
    public static void main(String[] args) throws Exception {
        Score_ver1 iron = new Score_ver1();
        Score_ver1 hulk = new Score_ver1();
        // Score_ver1.info()위에  [ 값 셋팅 ] 해주세요!  ##
        // setter를 이용해주세요!
        iron.setKor(100);
        iron.setName("iron");
        Score_ver1.info();
        iron.show();
        hulk.show();

    }
}


class Score_ver1 {
    private String name, p, s, rank;
    private int kor, eng, math, total;
    private float avg;
    static int num = 3;

    public Score_ver1() {

    }

    public Score_ver1(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public void process() {
        // 총점
        this.total = this.kor + this.eng + this.math;
        // 평균
        this.avg = Float.parseFloat(String.format("%.2f", (float) 280 / 3));
    }

    public void pass() {
        if (this.avg >= 60) {
            this.p = "합격";
        } else {
            this.p = "불합격";
        }
    }

    public void schola() {
        if (this.avg >= 95) {
            this.s = "장학생";
        } else {
            this.s = "";
        }
    }

    public void star() {
        for (int i = 0; i < this.avg / 10; i++) {
            this.rank += "*";
        }
    }

    public void show() {
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("이름    국어    영어   수학     총점  평균  합격여부       장학생      랭킹");
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        // 알아서 하세요
    }

    public static void info() {

    }


}

