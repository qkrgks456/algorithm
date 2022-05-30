package mylove.studymylove4.inter;

public class Star implements ScoreProcess{
    @Override
    public String exec(double aver) {
        String s = "";
        for (int i = 0; i < aver / 10; i++) {
            s += "*";
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
