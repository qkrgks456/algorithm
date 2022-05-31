package mylove.studymylove4.extentds.extends6;

import java.util.Scanner;

public class Score_v2 extends Score_v1 {
    private int spring, project, total;
    private double avg;

    @Override
    public void input() {
        super.input();
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        System.out.print("SPRING 입력 : ");
        n = scanner.nextInt();
        setSpring(n);
        System.out.print("PROJECT 입력 : ");
        n = scanner.nextInt();
        setProject(n);
    }

    public void process_total() {
        this.total = super.getJava() + super.getJsp() + super.getMysql() + getProject() + getSpring();
    }

    public void process_avg() {
        this.avg = (double) this.total / 5;
    }

    @Override
    void show() {
        super.show();
        System.out.print(this.spring + "     " + this.project + "     " + this.total + "     " + this.avg);
    }

    public int getSpring() {
        return spring;
    }

    public void setSpring(int spring) {
        this.spring = spring;
    }

    public int getProject() {
        return project;
    }

    public void setProject(int project) {
        this.project = project;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
