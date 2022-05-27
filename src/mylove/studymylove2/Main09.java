package mylove.studymylove2;

public class Main09 {
    public static void main(String[] args) {
        String[] name = {"아이언맨", "헐크  ", "캡틴  ", "토르  ", "호크아이"};
        String hap[] = new String[5];
        String jang[] = {"", "", "", "", ""};
        String[] star = {"", "", "", "", ""};
        int[] kor = {100, 20, 90, 70, 35};
        int[] eng = {100, 50, 95, 80, 100};
        int[] math = {100, 30, 90, 60, 100};
        float[] avg = new float[5];
        int[] rank = {1, 1, 1, 1, 1};
        // 평균
        for (int i = 0; i < name.length; i++) {
            avg[i] = (float) (kor[i] + eng[i] + math[i]) / 3;
        }
        // 등수
        for (int i = 0; i < name.length; i++) {
            int check = 1;
            for (int j = 0; j < name.length; j++) {
                if (avg[i] < avg[j]) {
                    check++;
                }
            }
            rank[i] = check;
        }
        // 장학생
        for (int i = 0; i < avg.length; i++) {
            if (avg[i] >= 95) {
                jang[i] = "장학생";
            }
        }
        // hap
        for (int i = 0; i < avg.length; i++) {
            if (avg[i] >= 60) {
                hap[i] = "합격";
                boolean check = false;
                if (kor[i] < 40) {
                    check = true;
                }
                if (eng[i] < 40) {
                    check = true;
                }
                if (math[i] < 40) {
                    check = true;
                }
                if (check) {
                    hap[i] = "재시험";
                }
            } else {
                hap[i] = "불합격";
            }
        }
        // 별
        for (int i = 0; i < avg.length; i++) {
            int n = (int) avg[i] / 10;
            String s = "";
            for (int j = 0; j < n; j++) {
                s += "별";
            }
            star[i] = s;
        }
        int count = 0;
        for (int i = 0; i < avg.length; i++) {
            if (avg[i] >= 80) {
                count++;
            }
        }

        // 출력
        System.out.println("이름      국어  영어  수학  평균  등수  합격여부        장학생     랭킹");
        float max = Integer.MIN_VALUE;
        float min = Integer.MAX_VALUE;
        for (int i = 0; i < name.length; i++) {
            // 최고 최저
            max = Math.max(avg[i], max);
            min = Math.min(avg[i], min);
            // 정수 판별
            if (avg[i] - (int) avg[i] == 0.0) {
                System.out.println(name[i] + "      " + kor[i] + "  " + eng[i] + "  " + math[i] + "  "
                        + (int) avg[i] + "  " + rank[i] + "   " + hap[i] + "      " + jang[i] + "      " + star[i]);
            } else {
                System.out.println(name[i] + "      " + kor[i] + "  " + eng[i] + "  " + math[i] + "  "
                        + Math.round(avg[i] * 100) / 100.0 + "  " + rank[i] + "   " + hap[i] + "      " + jang[i] + "      " + star[i]);
            }
        }
    }

    private static void process_show(String[] name, int[] kor, int[] eng, int[] math, float[] avg, int[] rank, String[] pass, String[] jang, String[] star) {

    }

    private static void process_star(float[] avg, String[] star) {

    }

    private static void process_pass(float[] avg, int[] kor, int[] eng, int[] math, String[] pass) {

    }

    private static void process_scholar(float[] avg, String[] jang) {

    }

    private static void process_rank(int size, float[] avg, int[] rank) {

    }

    private static float prcess_aver(int kor, int eng, int math) {
        return (float) (kor + eng + math) / 3;
    }
}
