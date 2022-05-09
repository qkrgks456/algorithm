package studymylove;

import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        String[][] users = {
                {"", "", ""},
                {"", "", ""},
                {"", "", ""}
        };
        int num;
        int[] removeNum = new int[3];
        int cnt = 0;
        String inputId, inputPass, inputBalance;
        int money, balance, checkNum = 0;
        boolean check;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("============= BANK ============");
            System.out.print("1.추가\n2.조회\n3.입금\n4.출금\n5.삭제\n9.종료\n입력 >>> ");
            num = scanner.nextInt();
            switch (num) {
                case 1:
                    // 3명 초과시 추가 불가
                    if (cnt >= 3) {
                        System.out.println("더 이상 추가 불가합니다");
                        break;
                    }
                    System.out.println("아이디 : ");
                    inputId = scanner.next();
                    System.out.println("비밀번호 : ");
                    inputPass = scanner.next();
                    System.out.println("잔액 : ");
                    inputBalance = scanner.next();
                    // 삭제 배열 확인
                    check = false;
                    for (int i = 0; i < removeNum.length; i++) {
                        // 삭제 배열에서 삭제된 인덱스를 가져온다
                        if (removeNum[i] == 1) {
                            removeNum[i] = 0;
                            checkNum = i;
                            check = true;
                            break;
                        }
                    }
                    if (check) {
                        // 삭제된 녀석이 있다면
                        users[checkNum][0] = inputId;
                        users[checkNum][1] = inputPass;
                        users[checkNum][2] = inputBalance;
                    } else {
                        // 삭제된 녀석이 없다면
                        users[cnt][0] = inputId;
                        users[cnt][1] = inputPass;
                        users[cnt][2] = inputBalance;
                    }
                    cnt++;
                    break;
                case 2:
                    System.out.println("조회기능입니다");
                    System.out.println("본인확인ID :");
                    inputId = scanner.next();
                    System.out.println("본인확인pass :");
                    inputPass = scanner.next();
                    check = false;
                    for (int i = 0; i < 3; i++) {
                        // 0 1 2
                        if (inputId.equals(users[i][0]) && inputPass.equals(users[i][1])) {
                            // checkNum으로 로그인에 성공했다면 해당 인덱스 배열을 조회한다
                            checkNum = i;
                            check = true;
                        }
                    }
                    // check로 로그인 확인
                    if (check) {
                        // 로그인 성공
                        System.out.println("반갑습니다 고객님");
                        System.out.println("id : " + users[checkNum][0]);
                        System.out.println("pass : " + users[checkNum][1]);
                        System.out.println("balance : " + users[checkNum][2]);
                    } else {
                        // 로그인 실패
                        System.out.println("다시 시도해 주세요");
                    }
                    break;
                case 3:
                    System.out.println("입금기능입니다");
                    System.out.println("본인확인ID :");
                    inputId = scanner.next();
                    System.out.println("본인확인pass :");
                    inputPass = scanner.next();
                    check = false;
                    for (int i = 0; i < 3; i++) {
                        // 0 1 2
                        if (inputId.equals(users[i][0]) && inputPass.equals(users[i][1])) {
                            // checkNum으로 로그인에 성공했다면 해당 인덱스 배열을 조회한다
                            checkNum = i;
                            check = true;
                        }
                    }
                    // check로 로그인 확인
                    if (check) {
                        // 로그인 성공
                        System.out.println("입금할 금액을 입금해주세요");
                        money = scanner.nextInt();
                        balance = Integer.parseInt(users[checkNum][2]);// 문자열을 숫자로
                        users[checkNum][2] = String.valueOf(balance + money); // 숫자를 다시 문자열로
                        System.out.println("잔액확인");
                        System.out.println("id : " + users[checkNum][0]);
                        System.out.println("pass : " + users[checkNum][1]);
                        System.out.println("balance : " + users[checkNum][2]);
                    } else {
                        // 로그인 실패
                        System.out.println("다시 시도해 주세요");
                    }
                    break;
                case 4:
                    System.out.println("출금기능입니다");
                    System.out.println("본인확인ID :");
                    inputId = scanner.next();
                    System.out.println("본인확인pass :");
                    inputPass = scanner.next();
                    check = false;
                    for (int i = 0; i < 3; i++) {
                        // 0 1 2
                        if (inputId.equals(users[i][0]) && inputPass.equals(users[i][1])) {
                            // checkNum으로 로그인에 성공했다면 해당 인덱스 배열을 조회한다
                            checkNum = i;
                            check = true;
                        }
                    }
                    // check로 로그인 확인
                    if (check) {
                        // 로그인 성공
                        System.out.println("출금할 금액을 입력해주세요");
                        money = scanner.nextInt();
                        balance = Integer.parseInt(users[checkNum][2]);// 문자열을 숫자로
                        users[checkNum][2] = String.valueOf(balance - money); // 숫자를 다시 문자열로
                        System.out.println("잔액확인");
                        System.out.println("id : " + users[checkNum][0]);
                        System.out.println("pass : " + users[checkNum][1]);
                        System.out.println("balance : " + users[checkNum][2]);
                    } else {
                        // 로그인 실패
                        System.out.println("다시 시도해 주세요");
                    }
                    break;
                case 5:
                    // 삭제
                    System.out.println("삭제기능입니다");
                    System.out.println("본인확인ID :");
                    inputId = scanner.next();
                    System.out.println("본인확인pass :");
                    inputPass = scanner.next();
                    check = false;
                    for (int i = 0; i < 3; i++) {
                        if (inputId.equals(users[i][0]) && inputPass.equals(users[i][1])) {
                            // checkNum으로 로그인에 성공했다면 해당 인덱스 배열을 조회한다
                            checkNum = i;
                            check = true;
                        }
                    }
                    if (check) {
                        users[checkNum][0] = "";
                        users[checkNum][1] = "";
                        users[checkNum][2] = "0";
                        System.out.println("잔액확인");
                        System.out.println("id : " + users[checkNum][0]);
                        System.out.println("pass : " + users[checkNum][1]);
                        System.out.println("balance : " + users[checkNum][2]);
                        cnt--;
                        // 삭제 배열 체크하기
                        removeNum[checkNum] = 1;
                    } else {
                        // 로그인 실패
                        System.out.println("다시 시도해 주세요");
                    }
                    break;
                case 9:
                    System.out.println("종료기능입니다");
                    System.exit(0);
            }
        }
    }
}
