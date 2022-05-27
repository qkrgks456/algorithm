package mylove.studymylove;

import java.util.Scanner;

public class Bank005 {
    static String[][] users = {
            {"", "", ""},
            {"", "", ""},
            {"", "", ""}
    };
    static int[] removeNum = new int[3];

    public static void main(String[] args) {
        int cnt = 0;
        int money = 0;
        String inputId, inputPass, inputBalance;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("============= BANK ============");
            System.out.println("1.추가");
            System.out.println("2.조회");
            System.out.println("3.입금");
            System.out.println("4.출금");
            System.out.println("5.삭제");
            System.out.println("9.종료");
            System.out.print("입력 >>> ");
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    // 3명 초과시 추가 불가
                    if (cnt >= 3) {
                        System.out.println("더 이상 추가 불가합니다");
                        break;
                    }
                    System.out.println("아이디 : ");
                    inputId = scanner.next();
                    // 중복체크
                    if (overlap(inputId)) break;
                    System.out.println("비밀번호 : ");
                    inputPass = scanner.next();
                    System.out.println("잔액 : ");
                    inputBalance = scanner.next();
                    // 유저추가
                    userAdd(inputId, inputPass, inputBalance, cnt);
                    System.out.println("추가 성공");
                    cnt++;
                    break;
                case 2:
                    System.out.println("조회기능입니다");
                    System.out.println("본인확인ID :");
                    inputId = scanner.next();
                    System.out.println("본인확인pass :");
                    inputPass = scanner.next();
                    // 조회
                    userCheck(inputId, inputPass);
                    break;
                case 3:
                    System.out.println("입금기능입니다");
                    System.out.println("본인확인ID :");
                    inputId = scanner.next();
                    System.out.println("본인확인pass :");
                    inputPass = scanner.next();
                    System.out.println("입금할 금액을 입금해주세요");
                    money = scanner.nextInt();
                    // 입금
                    putMoney(inputId, inputPass, money);
                    break;
                case 4:
                    System.out.println("출금기능입니다");
                    System.out.println("본인확인ID :");
                    inputId = scanner.next();
                    System.out.println("본인확인pass :");
                    inputPass = scanner.next();
                    System.out.println("출금할 금액을 입력해주세요");
                    money = scanner.nextInt();
                    // 출금
                    getMoney(inputId, inputPass, money);
                    break;
                case 5:
                    // 삭제
                    System.out.println("삭제기능입니다");
                    System.out.println("본인확인ID :");
                    inputId = scanner.next();
                    System.out.println("본인확인pass :");
                    inputPass = scanner.next();
                    userDelete(inputId, inputPass);
                    cnt--;
                    break;
                case 9:
                    System.out.println("종료기능입니다");
                    System.exit(0);
                    break;
            }
        }
    }

    public static int selfCheck(String inputId, String inputPass) {
        int check = -1;
        for (int i = 0; i < 3; i++) {
            if (inputId.equals(users[i][0]) && inputPass.equals(users[i][1])) {
                check = i;
            }
        }
        return check;
    }

    public static boolean overlap(String inputId) {
        for (int i = 0; i < 3; i++) {
            if (inputId.equals(users[i][0])) {
                System.out.println("중복된 아이디 입니다 다시 시도해주세요.");
                return true;
            }
        }
        return false;
    }

    // 잔액확인
    public static void moneyCheck(int location) {
        System.out.println("잔액확인");
        System.out.println("id : " + users[location][0]);
        System.out.println("pass : " + users[location][1]);
        System.out.println("balance : " + users[location][2]);
    }

    // 추가
    public static void userAdd(String inputId, String inputPass, String inputBalance, int cnt) {
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
    }

    // 조회
    public static void userCheck(String inputId, String inputPass) {
        int location = selfCheck(inputId, inputPass);
        if (location >= 0) {
            // 로그인 성공
            System.out.println("반갑습니다 고객님");
            System.out.println("id : " + users[location][0]);
            System.out.println("pass : " + users[location][1]);
            System.out.println("balance : " + users[location][2]);
        } else {
            // 로그인 실패
            System.out.println("다시 시도해 주세요");
        }
    }

    // 입금
    public static void putMoney(String inputId, String inputPass, int money) {
        int location = selfCheck(inputId, inputPass);
        if (location >= 0) {
            // 로그인 성공
            int balance = Integer.parseInt(users[location][2]);// 문자열을 숫자로
            users[location][2] = String.valueOf(balance + money); // 숫자를 다시 문자열로
            moneyCheck(location);
        } else {
            // 로그인 실패
            System.out.println("다시 시도해 주세요");
        }
    }

    // 출금
    public static void getMoney(String inputId, String inputPass, int money) {
        // 본인 확인
        int location = selfCheck(inputId, inputPass);
        if (location >= 0) {
            // 로그인 성공
            int balance = Integer.parseInt(users[location][2]);// 문자열을 숫자로
            users[location][2] = String.valueOf(balance - money); // 숫자를 다시 문자열로
            moneyCheck(location);
        } else {
            // 로그인 실패
            System.out.println("다시 시도해 주세요");
        }
    }

    // 삭제
    public static void userDelete(String inputId, String inputPass) {
        // 본인 확인
        int location = selfCheck(inputId, inputPass);
        if (location >= 0) {
            users[location][0] = "";
            users[location][1] = "";
            users[location][2] = "0";
            // 삭제 배열 체크하기
            removeNum[location] = 1;
            System.out.println("삭제 성공");
        } else {
            // 로그인 실패
            System.out.println("다시 시도해 주세요");
        }
    }
}