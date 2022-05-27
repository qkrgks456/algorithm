package mylove.studymylove3;

public class Test {
    public static void main(String[] args) {
        Score_ver1 iron = new Score_ver1();
        Score_ver1 hulk = new Score_ver1();
        iron.setKor(100);
        iron.setAvg(100);
        iron.setEng(100);
        iron.setName("아이언맨");
        hulk.setKor(20);
        hulk.setEng(50);
        hulk.setMath(30);
        hulk.setName("헐크");
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

    @Override
    public String toString() {
        return " " + name + " " + eng + " " + math + " " + total + " " + avg + " " + p + " " + s + " " + rank;
    }

    public Score_ver1() {

    }

    public Score_ver1(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }


    public void process() {
        // 총점
        this.total = this.kor + this.eng + this.math;
        // 평균
        this.avg = Float.parseFloat(String.format("%.2f", (float) total / 3));
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
        this.rank = "";
        for (int i = 0; i < this.avg / 10; i++) {
            this.rank += "*";
        }
    }

    public void show() {
        process();
        pass();
        schola();
        star();
        System.out.println(name + " " + kor + " " + eng + " " + math + " " + total + " " + avg + " " + p + " " + s + " " + rank);
    }

    public static void info() {
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("이름    국어    영어   수학     총점  평균  합격여부       장학생      랭킹");
        System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public float getAvg() {
        return avg;
    }

    public void setAvg(float avg) {
        this.avg = avg;
    }
}

