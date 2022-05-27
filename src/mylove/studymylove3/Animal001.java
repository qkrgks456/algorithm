package mylove.studymylove3;

import java.util.Scanner;

public class Animal001 {
    String name;
    int age;

    void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("이름입력 > ");
        name = scanner.next();
        System.out.print("나이입력 > ");
        age = scanner.nextInt();
    }

    void show() {
        System.out.println("이름 : " + name);
        System.out.println("나이 : " + age);
    }
}
