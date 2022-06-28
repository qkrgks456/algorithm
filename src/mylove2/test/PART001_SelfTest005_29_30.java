package mylove2.test;


import javax.swing.*;

/***
 * @author CAT~sally (4WK) PART 클래스의 활용
//[SELFTEST029]  Thread(1) 사용법
ㅁ 두가지일 동시에 진행하능하게 Thread를 구현하시오
==================
1. 구구단 2~9단까지출력
==================
2. 1~100까지의 합
중간에 더해지는 과정보이기
==================

//[SELFTEST030]  Thread(2) 사용법
1. 10부터 1까지 거꾸로 카운트하고 난다음에  입력받는 다이얼로그창이 나온다.
for(int i=10; i > 0; i--) {
System.out.println(i);
try {
Thread.sleep(1000);
} catch(Exception e ) {}
}

String input = JOptionPane.showInputDialog("빨강의 알파벳을 입력하세요.");
System.out.println("입력하신 값은 " + input + "입니다.");
red를 입력하면  카운트가 stop되게 만들기
///////////////////////////////////////////////////////////////////
 ***/
public class PART001_SelfTest005_29_30 {
    public static void main(String[] args) throws Exception {
        // 29
        Thread thread1 = new Thread(() -> {
            for (int i = 2; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    System.out.println(i + " " + j + " " + " = " + i * j);
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {

                    }
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += i;
                System.out.println(sum);
                try {
                    Thread.sleep(100);
                } catch (Exception e) {

                }
            }
        });
       /* thread1.start();
        thread2.start();*/

        // 30
        Thread thread = new Thread(() -> {
            for (int i = 10; i > 0; i--) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                }
            }
        });
        thread.start();
        thread.join();
        String input = JOptionPane.showInputDialog("빨강의 알파벳을 입력하세요.");
        System.out.println("입력하신 값은 " + input + "입니다.");
    }
}
