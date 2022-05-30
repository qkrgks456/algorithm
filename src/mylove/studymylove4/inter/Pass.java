package mylove.studymylove4.inter;

public class Pass implements ScoreProcess{
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
    public int exec(int kor, int eng, int math) {
        return 0;
    }

    @Override
    public double exec(int total) {
        return 0;
    }
}
