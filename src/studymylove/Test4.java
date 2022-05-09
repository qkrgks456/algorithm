package studymylove;

import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0, n1 = 0, n2 = 0;
        char c = ' ';


        for (; ; ) {
            if (num == 0) {
                System.out.println("정수를 하나 입력해주세요");
                n1 = scanner.nextInt();
                // 20
                if (n1 < 0 || n1 > 100) {
                    continue;
                }
                num = 1;
            }  //if 조건이 충족되면 다음 코드가 실행되지 않음 continue (건너띄고 계속되다) 돼서 계속 반복
            //  예를 들어 -1이나 105가 되면 num =1; 가 되지 않는다
            // 그래서 다음으로 넘어가지 않고 계속 정수를 하나 입력해주세요 반복
            else if (num == 1) {  //   num = 1;
                System.out.println("정수를 하나 입력해주세요");
                n2 = scanner.nextInt();
                if (n2 < 0 || n2 > 100) {
                    continue;
                }
                num = 2;
            }
            // 위에와 동일 조건이 충족되지 않아야 num2가 돼서 다음 코드가 실행
            else if (num == 2) {
                System.out.println("연산자를 입력해주세요");
                c = scanner.next().charAt(0);
                if (c != '+' && c != '-' && c != '*' && c != '/') {
                    continue;
                }
                break;
            }  //num2가 돼서 여기 코드가 실행됨
        }


        int result = 0;
        switch (c) {
            case '+':
                result = n1 + n2;
                break;
            case '-':
                result = n1 - n2;
                break;
            case '*':
                result = n1 * n2;
                break;
            case '/':
                result = n1 / n2;
                break;
        }
        System.out.println(n1 + " " + c + " " + n2 + " = " + result);
    }
}
