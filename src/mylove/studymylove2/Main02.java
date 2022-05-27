package mylove.studymylove2;

public class Main02 {
    public static void main(String[] args) {
        myCalender(2019, 2, 27);
    }

    public static void myCalender(int year, int month, int day) {
        int sum = 0;
        for (int i = 1; i < year; i++) {
            if (leap(i)) {
                // 윤년
                sum += 366;
            } else {
                // 평년
                sum += 365;
            }
        }
        int[] mon = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        for (int i = 0; i < month; i++) {
            sum += mon[i];
        }
        sum += day;
        if (leap(year)) {
            sum++;
        }
        show(sum, year, month, day, mon[month]);
    }

    public static String week(int key) {
        String s = "";
        switch (key % 7) {
            case 0:
                s = "일요일";
                break;
            case 1:
                s = "월요일";
                break;
            case 2:
                s = "화요일";
                break;
            case 3:
                s = "수요일";
                break;
            case 4:
                s = "목요일";
                break;
            case 5:
                s = "금요일";
                break;
            case 6:
                s = "토요일";
                break;
        }
        return s;
    }

    public static void show(int sum, int year, int month, int day, int sumDay) {
        System.out.println("* 서기1년 ~ 오늘총날수 : " + sum);
        System.out.println("* " + year + "년 " + month + "월 " + day + "일 " + week(sum));
        System.out.println("========== " + month + "월 ==========");
        System.out.println("일  월  화  수  목  금  토 ");
        int week = (day % 7) - 1;
        for (int i = 0; i < week; i++) {
            System.out.print("*  ");
        }
        for (int i = 1; i <= sumDay; i++) {
            System.out.print(i + "  ");
            week++;
            if (week % 7 == 0) {
                System.out.println();
            }
        }
    }

    public static boolean leap(int year) {
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            return true;
        }
        return false;
    }


}
