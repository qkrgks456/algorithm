package mylove.studymylove5.extends2;

public class Main {
    public static void main(String[] args) {
        Student_h student = new Student_h("아이언맨", "123456-1234567", 1);
        System.out.println("name : " + student.name);
        System.out.println("ssn : " + student.ssn);
        System.out.println("studentNo : " + student.studentNo);
        Student_h student2 = new Student_h();
        System.out.println(student2);
    }
}
