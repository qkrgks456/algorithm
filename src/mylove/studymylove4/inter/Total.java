package mylove.studymylove4.inter;

public class Total implements ScoreProcess {
    @Override
    public String exec(double aver) {
        return null;
    }

    @Override
    public int exec(int kor, int eng, int math) {
        return kor + eng + math;
    }

    @Override
    public double exec(int total) {
        return 0;
    }
}
