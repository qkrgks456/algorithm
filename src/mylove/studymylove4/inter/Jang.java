package mylove.studymylove4.inter;

public class Jang implements ScoreProcess{
    @Override
    public String exec(double aver) {
        String s = "";
        if (aver >= 95) {
            s = "장학생";
        } else {
            s = "";
        }
        return s;
    }

    @Override
    public int exec(int kor, int eng, int math) {
        return 0;
    }

    @Override
    public double exec(int total) {
        return 0;
    }
}
