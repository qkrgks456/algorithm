package mylove.studymylove3;

import java.util.Scanner;

public class Main05 {
    public static void main(String[] args) {
        Coffee003 a1 = new Coffee003("아메리카노", 3);
        Coffee003 a2 = new Coffee003();

        a1.show();
        a2.input();
        a2.show();
    }
}

class Coffee003 {
    String name;
    int price;
    int num;

    @Override
    public String toString() {
        return "커피명: " + name + "갯수: " + num;
    }

    public Coffee003() {
    }

    public Coffee003(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public Coffee003(String name, int price, int num) {
        this.name = name;
        this.price = price;
        this.num = num;
    }

    void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("커피명 > ");
        name = scanner.next();
        System.out.println("갯수 >");
        num = scanner.nextInt();
    }

    void show() {
        coffe_calc();
        System.out.println("커피명 :" + name);
        System.out.println("커피잔수 : " + num);
        System.out.println("가격 :" + price);
    }

    void coffe_calc() {
        switch (this.name) {
            case "아메리카노":
                this.price = this.num * 1000;
                break;
            case "카페라떼":
                this.price = this.num * 1500;
                break;
            case "카푸치노":
                this.price = this.num * 2000;
                break;
        }
    }
}
