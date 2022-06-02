package mylove.studymylove4;

public class Process {
    public Process() {
        super();
    }

    public double[] exec(int kor, int eng, int math) {
        double[] doubles = new double[2];
        // 총점
        int total = kor + eng + math;
        // 평균
        doubles[0] = total;
        doubles[1] = total / 3;
        return doubles;
    }


    public String exec(double aver) {
        String s = "";
        if (aver >= 60) {
            s = "합격";
        } else {
            s = "불합격";
        }
        return s;
    }


    public String exec_jang(double aver) {
        String s = "";
        if (aver >= 95) {
            s = "장학생";
        } else {
            s = "";
        }
        return s;
    }


    public String star(double aver) {
        String s = "";
        for (int i = 0; i < aver / 10; i++) {
            s += "*";
        }
        return s;
    }

    public void show(Score_ver2 iron) {
        double[] doubles = exec(iron.getKor(), iron.getEng(), iron.getMath());
        iron.setTotal((int) doubles[0]);
        iron.setAvg(doubles[1]);
        iron.setP(exec(iron.getAvg()));
        iron.setS(exec_jang(iron.getAvg()));
        iron.setRank(star(iron.getAvg()));
        float avg = Float.parseFloat(String.format("%.2f", (float) iron.getAvg()));
        // 출력은 본인이 ..
        System.out.println(iron.getName() + " " + iron.getKor() + " " + iron.getEng() + " "
                + iron.getMath() + " " + iron.getS() + " " + iron.getP() + " " + iron.getTotal() + " " + avg + " " + iron.getRank());
    }

}
