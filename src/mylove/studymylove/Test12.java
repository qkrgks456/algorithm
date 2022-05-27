package mylove.studymylove;

import java.util.Scanner;

public class Test12 {
    public static void main(String[] args) {
        String[][] users = new String[5][9];
        Scanner scanner = new Scanner(System.in);
        String name[] = {"아이언맨", "엄크", "엄틴", "엄르", "엄크아이"};
        int[] kor = {100, 20, 90, 70, 35};
        int[] eng = {100, 50, 95, 80, 100};
        int[] math = {100, 30, 90, 60, 100};
        // 이름 점수 평균 넣기
        for (int i = 0; i < 5; i++) {
            users[i][0] = name[i];
            users[i][1] = String.valueOf(kor[i]);
            users[i][2] = String.valueOf(eng[i]);
            users[i][3] = String.valueOf(math[i]);
            int tot = kor[i] + eng[i] + math[i];
            int avg = tot / 3;
            users[i][4] = String.valueOf(avg);
        }
        // 이차원 배열 정렬 -> 많이 어려우니 나중에 알려쥬께요
        /*Arrays.sort(users, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                int n1 = Integer.parseInt(o1[4]);
                int n2 = Integer.parseInt(o2[4]);
                return n2 - n1;
            }
        });
        // 등수
        users[0][5] = "1";
        for (int i = 1; i < 5; i++) {
            if (users[i - 1][4].equals(users[i][4])) {
                users[i][5] = users[i - 1][5];
            } else {
                int num = Integer.parseInt(users[i - 1][5]);
                num++;
                users[i][5] = String.valueOf(num);
            }
        }*/
        // 여기부터 합격여부 장학생 랭킹
        for (int i = 0; i < 5; i++) {
            int avg = Integer.parseInt(users[i][4]);
            int rank = 1;
            for (int j = 0; j < 5; j++) {
                if (avg < Integer.parseInt(users[j][4])) {
                    rank++;
                }
            }
            users[i][5] = String.valueOf(rank);
            if (avg >= 95) {
                users[i][7] = "장학생";
            } else {
                users[i][7] = "----";
            }
            if (avg >= 60) {
                users[i][6] = "합격" + " ";
            } else {
                users[i][6] = "불합격";
            }
            int result = avg / 10;
            users[i][8] = "";
            for (int j = 0; j < result; j++) {
                users[i][8] += "별";
            }
        }
        // 출력
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        System.out.println("이름         국어       영어      수학      평균      등수  합격여부    장학생     랭킹");
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
        for (int i = 0; i < users.length; i++) {
            for (int j = 0; j < users[i].length; j++) {
                System.out.print(users[i][j] + "\t\t");
            }
            System.out.println();
        }
        System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::");
    }

}
