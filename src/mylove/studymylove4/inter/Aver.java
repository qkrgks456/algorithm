package mylove.studymylove4.inter;

public class Aver implements ScoreProcess {
    @Override
    public String exec(double aver) {
        return null;
    }

    @Override
    public int exec(int kor, int eng, int math) {
        return 0;
    }

    @Override
    public double exec(int total) {
        return total / 3;
    }
}
