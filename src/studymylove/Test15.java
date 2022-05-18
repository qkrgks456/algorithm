package studymylove;

import java.util.Scanner;

public class Test15 {
    static int cnt = 0;
    static Scanner scanner = new Scanner(System.in);
    static int[] removeNum = new int[3];

    public static void main(String[] args) throws Exception {
        /////// 변수

        String[][] users = {
                {"", "", ""},  //00 01 02
                {"", "", ""},  //10 11 12
                {"", "", ""}   //20 21 22
        };
        int num = 0;
        do {
            menu();
            num = scanner.nextInt();
            switch (num) {
                case 1:
                    input(users);
                    break;
                case 2:
                    show(users);
                    break;
                case 3:
                    deposit(users);
                    break;
                case 4:
                    withdraw(users);
                    break;
                case 5:
                    delete(users);
                    break;
            }
        } while (num != 9);
    }

    private static void delete(String[][] users) {
        System.out.println("삭제기능입니다");
        System.out.println("본인확인ID :");
        String inputId = scanner.next();
        System.out.println("본인확인pass :");
        String inputPass = scanner.next();
        int location = selfCheck(inputId, inputPass, users);
        if (location >= 0) {
            System.out.println("삭제하시겠습니까? (y/n)");
            String s = scanner.next();
            if (s.equals("y")) {
                users[location][0] = "";
                users[location][1] = "";
                users[location][2] = "0";
                // 삭제 배열 체크하기
                removeNum[location] = 1;
                System.out.println("삭제 성공");
            } else {
                return;
            }
        } else {
            // 로그인 실패
            System.out.println("계좌 정보가 없습니다.");
        }
        cnt--;
    }

    private static void withdraw(String[][] users) {
        System.out.println("출금기능입니다");
        System.out.println("본인확인ID :");
        String inputId = scanner.next();
        System.out.println("본인확인pass :");
        String inputPass = scanner.next();
        // 본인 확인
        int location = selfCheck(inputId, inputPass, users);
        if (location >= 0) {
            // 로그인 성공
            System.out.println("출금할 금액을 입력해주세요");
            int money = scanner.nextInt();
            int balance = Integer.parseInt(users[location][2]);// 문자열을 숫자로
            users[location][2] = String.valueOf(balance - money); // 숫자를 다시 문자열로
            moneyCheck(location, users, money);
        } else {
            // 로그인 실패
            System.out.println("계좌 정보가 없습니다.");
        }
    }

    private static void deposit(String[][] users) {
        System.out.println("입금기능입니다");
        System.out.println("본인확인ID :");
        String inputId = scanner.next();
        System.out.println("본인확인pass :");
        String inputPass = scanner.next();
        int location = selfCheck(inputId, inputPass, users);
        if (location >= 0) {
            // 로그인 성공
            System.out.println("입금할 금액을 입금해주세요");
            int money = scanner.nextInt();
            int balance = Integer.parseInt(users[location][2]);// 문자열을 숫자로
            users[location][2] = String.valueOf(balance + money); // 숫자를 다시 문자열로
            moneyCheck(location, users, money);
        } else {
            // 로그인 실패
            System.out.println("계좌 정보가 없습니다.");
        }
    }

    private static void show(String[][] users) throws Exception {
        System.out.println("조회기능입니다");
        System.out.println("본인확인ID :");
        String inputId = scanner.next();
        System.out.println("본인확인pass :");
        String inputPass = scanner.next();
        int location = selfCheck(inputId, inputPass, users);
        if (location >= 0) {
            // 로그인 성공
            System.out.println("id : " + users[location][0]);
            System.out.println("pass : " + users[location][1]);
            System.out.println("balance : " + users[location][2]);
            System.out.println("조회가 성공했습니다.");
        } else {
            // 로그인 실패
            System.out.println("조회가 실패했습니다.");
        }
        System.out.println("아무키나 입력해주세요");
        scanner.next();
    }

    private static void input(String[][] users) {
        // 3명 초과시 추가 불가
        if (cnt >= 3) {
            System.out.println("더 이상 추가 불가합니다");
            return;
        }
        System.out.println("아이디 : ");
        String inputId = scanner.next();
        // 중복체크
        for (int i = 0; i < 3; i++) {
            if (inputId.equals(users[i][0])) {
                System.out.println("중복된 아이디 입니다 다시 시도해주세요.");
                return;
            }
        }
        System.out.println("비밀번호 : ");
        String inputPass = scanner.next();
        System.out.println("잔액 : ");
        String inputBalance = scanner.next();
        // 유저추가
        boolean check = true;
        // 삭제된 녀석이 있다면
        for (int i = 0; i < removeNum.length; i++) {
            if (removeNum[i] == 1) {
                removeNum[i] = 0;
                users[i][0] = inputId;
                users[i][1] = inputPass;
                users[i][2] = inputBalance;
                check = false;
                break;
            }
        }
        // 삭제된 녀석이 없다면
        if (check) {
            users[cnt][0] = inputId;
            users[cnt][1] = inputPass;
            users[cnt][2] = inputBalance;
        }
        System.out.println("추가 성공");
        cnt++;
    }

    private static void menu() {
        System.out.println("============= BANK ============");
        System.out.println("1.추가");
        System.out.println("2.조회");
        System.out.println("3.입금");
        System.out.println("4.출금");
        System.out.println("5.삭제");
        System.out.println("9.종료");
        System.out.print("입력 >>> ");
    }

    public static int selfCheck(String inputId, String inputPass, String[][] users) {
        int check = -1;
        for (int i = 0; i < 3; i++) {
            if (inputId.equals(users[i][0]) && inputPass.equals(users[i][1])) {
                check = i;
            }
        }
        return check;
    }

    public static void moneyCheck(int location, String[][] users, int money) {
        System.out.println("id : " + users[location][0]);
        System.out.println("pass : " + users[location][1]);
        System.out.println("입금액 : " + money);
    }
}
