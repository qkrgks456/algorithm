package mylove.studymylove5.extends3;

public class Main {
    public static void main(String[] args) {
        int r = 10;
        Calculator_h calculator = new Calculator_h();
        System.out.println("원면적  : " + calculator.areaCircle(r));
        System.out.println();
        Computer_h computer = new Computer_h();
        System.out.println("원면적  : " + computer.areaCircle(r));
    }
}
