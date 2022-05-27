package mylove.studymylove2;

public class Main05 {
    public static void main(String[] args) {
        String[] name = {"아이엄맨", "엄크", "엄틴", "엄르", "엄크아이"};
        int size = name.length;
        int[] kor = {100, 20, 90, 70, 35};
        int[] eng = {100, 50, 95, 80, 100};
        int[] math = {100, 30, 90, 60, 100};
        int avg[] = new int[5];
        int rank[] = {1, 1, 1, 1, 1};
        String pass[] = new String[5];
        String jang[] = {"", "", "", "", ""};
        String star[] = {"", "", "", "", ""};
        // 평균
        for (int i = 0; i < size; i++) {
            avg[i] = prcess_aver(kor[i], eng[i], math[i]);
        }
        // 등수
        process_rank(size, avg, rank);
        // 장학생
        process_scholar(avg, jang);
        // pass
        process_pass(avg, kor, eng, math, pass);
        // 별
        process_star(avg, star);
        // 출력
        process_show(name, kor, eng, math, avg, rank, pass, jang, star);

    }

    private static void process_show(String[] name, int[] kor, int[] eng, int[] math, int[] avg, int[] rank, String[] pass, String[] jang, String[] star) {
        System.out.println("이름      국어  영어  수학  평균  등수  합격여부        장학생     랭킹");
        for (int i = 0; i < name.length; i++) {
            System.out.println(name[i] + "      " + kor[i] + "  " + eng[i] + "  " + math[i] + "  "
                    + avg[i] + "  " + rank[i] + "   " + pass[i] + "      " + jang[i] + "      " + star[i]);
        }
    }

    private static void process_star(int[] avg, String[] star) {
        for (int i = 0; i < avg.length; i++) {
            int n = avg[i] / 10;
            String s = "";
            for (int j = 0; j < n; j++) {
                s += "별";
            }
            star[i] = s;
        }
    }

    private static void process_pass(int[] avg, int[] kor, int[] eng, int[] math, String[] pass) {
        for (int i = 0; i < avg.length; i++) {
            if (avg[i] >= 60) {
                pass[i] = "합격";
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
                    pass[i] = "재시험";
                }
            } else {
                pass[i] = "불합격";
            }
        }
    }

    private static void process_scholar(int[] avg, String[] jang) {
        for (int i = 0; i < avg.length; i++) {
            if (avg[i] >= 95) {
                jang[i] = "장학생";
            }
        }
    }

    private static void process_rank(int size, int[] avg, int[] rank) {
        for (int i = 0; i < size; i++) {
            int check = 1;
            for (int j = 0; j < size; j++) {
                if (avg[i] < avg[j]) {
                    check++;
                }
            }
            rank[i] = check;
        }
    }

    private static int prcess_aver(int kor, int eng, int math) {
        return (kor + eng + math) / 3;
    }
}
