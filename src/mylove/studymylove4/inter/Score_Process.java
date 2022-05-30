package mylove.studymylove4.inter;

import mylove.studymylove4.Score_ver2;

// 왜 여러개를 만든지 모르곘습니다
public class Score_Process {
    public void show(Score_ver2 iron) {
        iron.setTotal(new Total().exec(iron.getKor(), iron.getEng(), iron.getMath()));
        iron.setAvg(new Aver().exec(iron.getTotal()));
        iron.setP(new Pass().exec(iron.getAvg()));
        iron.setS(new Jang().exec(iron.getAvg()));
        iron.setRank(new Star().exec(iron.getAvg()));
        float avg = Float.parseFloat(String.format("%.2f", (float) iron.getAvg()));
        // 출력은 본인이 ..
        System.out.println(iron.getName() + " " + iron.getKor() + " " + iron.getEng() + " "
                + iron.getMath() + " " + iron.getS() + " " + iron.getP() + " " + iron.getTotal() + " " + avg + " " + iron.getRank());
    }
}
