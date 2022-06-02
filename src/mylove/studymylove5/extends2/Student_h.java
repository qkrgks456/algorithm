package mylove.studymylove5.extends2;

public class Student_h extends People_h {
    public int studentNo;


    public Student_h(String name, String ssn, int studentNo) {
        super(name, ssn);
        this.studentNo = studentNo;
    }

    public Student_h() {

    }

    @Override
    public String toString() {
        return "Student_h{" +
                "studentNo=" + studentNo +
                '}';
    }
}
