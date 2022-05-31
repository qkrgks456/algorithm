package mylove.studymylove4.extentds.extends6;

import java.util.Scanner;

public class Score_v1 extends User {
    private int java, jsp, mysql;

    @Override
    void show() {
        super.show();
        System.out.print(this.java + "     " + this.jsp + "     " + this.mysql + "     ");
    }

    void input() {
        String s = "";
        int n = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("NAME 입력 : ");
        s = scanner.next();
        super.setName(s);
        System.out.print("ID 입력 : ");
        s = scanner.next();
        super.setId(s);
        System.out.print("JAVA 입력 : ");
        n = scanner.nextInt();
        setJava(n);
        System.out.print("JSP 입력 : ");
        n = scanner.nextInt();
        setJsp(n);
        System.out.print("MYSQL 입력 : ");
        n = scanner.nextInt();
        setMysql(n);
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getJsp() {
        return jsp;
    }

    public void setJsp(int jsp) {
        this.jsp = jsp;
    }

    public int getMysql() {
        return mysql;
    }

    public void setMysql(int mysql) {
        this.mysql = mysql;
    }
}
