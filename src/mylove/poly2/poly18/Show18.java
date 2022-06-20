package mylove.poly2.poly18;

import java.text.DecimalFormat;

public class Show18 {
    public void show(Score_ver18[] std) {
        System.out.println("::::::::::::::::::::::::::");
        System.out.println("이름  국어 영어 수학 총점 평균 합격여부 장학생 랭킹");
        System.out.println("::::::::::::::::::::::::::");
        for (Score_ver18 score_ver18 : std) {
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            System.out.println(score_ver18.getName() + " " + score_ver18.getKor() + " " + score_ver18.getEng()
                    + " " + score_ver18.getMath() + " " + score_ver18.getTotal() + " " + decimalFormat.format(score_ver18.getAver())
                    + " " + score_ver18.getP() + " " + score_ver18.getS() + " " + score_ver18.getRank());
        }
    }
}
