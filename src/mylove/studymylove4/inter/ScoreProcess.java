package mylove.studymylove4.inter;

import mylove.studymylove4.Score_ver2;

public interface ScoreProcess {

    default void show(Score_ver2 iron) {
        iron.setTotal(total(iron.getKor(), iron.getEng(), iron.getMath()));
        iron.setAvg(avg(iron.getTotal()));
        iron.setP(exec(iron.getAvg()));
        iron.setS(exec_jang(iron.getAvg()));
        iron.setRank(star(iron.getAvg()));
        float avg = Float.parseFloat(String.format("%.2f", (float) iron.getAvg()));
        // 출력은 본인이 ..
        System.out.println(iron.getName() + " " + iron.getKor() + " " + iron.getEng() + " "
                + iron.getMath() + " " + iron.getS() + " " + iron.getP() + " " + iron.getTotal() + " " + avg + " " + iron.getRank());
    }

    String star(double aver);

    String exec_jang(double aver);

    String exec(double aver);

    int total(int kor, int eng, int math);

    double avg(int total);
}
