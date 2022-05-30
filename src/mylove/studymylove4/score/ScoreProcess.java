package mylove.studymylove4.score;

public class ScoreProcess {


    public void process_avg(Score[] std) {
        for (int i = 0; i < std.length; i++) {
            float num = (float) (std[i].getKor() + std[i].getEng() + std[i].getMath()) / 3;
            std[i].setAvg((float) (Math.round(num * 100) / 100.0));
        }
    }

    public void process_pass(Score[] std) {
        for (int i = 0; i < std.length; i++) {
            String s = "";
            if (std[i].getAvg() >= 60) {
                s = "합격";
            } else {
                s = "불합격";
            }
            std[i].setPass(s);
        }
    }
}
