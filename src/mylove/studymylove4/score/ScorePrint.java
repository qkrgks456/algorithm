package mylove.studymylove4.score;

public class ScorePrint {
    public void show(Score std) {
        show_title();
        System.out.println(std.getName() + " " + std.getKor() + " " + std.getEng() + " " + std.getMath() + " " + std.getAvg() + " " + std.getPass());
    }

    public void show(Score[] std) {
        show_title();
        for (int i = 0; i < std.length; i++) {
            System.out.println(std[i].getName() + " " + std[i].getKor() + " " + std[i].getEng() + " " + std[i].getMath() + " " + std[i].getAvg() + " " + std[i].getPass());
        }
    }

    public void show_title() {
        System.out.println("================================================================");
        System.out.println("이름 국어 영어 수학 평균 합격여부");
        System.out.println("================================================================");
    }
}
