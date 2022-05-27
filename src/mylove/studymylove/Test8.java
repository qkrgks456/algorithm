package mylove.studymylove;

public class Test8 {
    public static void main(String[] args) {
        String[] name = {"아이언맨", "헐크", "캡틴", "토르", "호크아이"};
        int[] kor = {100, 100, 100, 70, 100};
        int[] eng = {100, 100, 20, 80, 100};
        int[] math = {100, 100, 30, 60, 100};
        int[] avg = new int[5];
        int[] rank = {1, 1, 1, 1, 1};
        String[] star = {"", "", "", "", ""};
        int size = name.length;
        for (int i = 0; i < avg.length; i++) {
            avg[i] = (kor[i] + eng[i] + math[i]) / 3;
        }
        // 평균 등수 구하기 단 avg배열이 내림차순으로 정렬되어야 한다.
        // 내림차순 정렬
        int start = 0;
        int end = avg.length - 1;
        while (start < end) {
            int num = avg[start];
            avg[start] = avg[end];
            avg[end] = num;
            start++;
            end--;
        }
        int count = 1;
        for (int i = 1; i < avg.length; i++) {
            if (avg[i] == avg[i - 1]) {
                rank[i] = count;
            } else {
                rank[i] = ++count;
            }
        }
        String goodCheck = "";
        String sucCheck = "";
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("이름       국어  영어  수학  평균     합격여부   장학생   랭킹");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        for (int i = 0; i < size; i++) {
            if (avg[i] >= 95) {
                goodCheck = "장학생";
            } else {
                goodCheck = "----";
            }
            if (avg[i] >= 60) {
                sucCheck = "합격";
            } else {
                sucCheck = "불합격";
            }
            // 별
            int check = avg[i] / 10;
            for (int j = 0; j < check; j++) {
                star[i] += "별";
            }
            System.out.println(name[i] + "      " + kor[i] + "  " + eng[i] + "  " + math[i] + "  " + avg[i] + "     " + sucCheck + "  " + goodCheck + "   "
                    + star[i] + "  " + rank[i]);
        }
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    }
}
