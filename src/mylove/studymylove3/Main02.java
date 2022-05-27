package mylove.studymylove3;

public class Main02 {
    public static void main(String[] args) {
        Student003 s3 = new Student003("홍길동", 1, 1, 100, 60, 76);
        System.out.println(s3.info());
    }
}

class Student003 {
    String name;
    int ban;
    int no;
    int kor;
    int eng;
    int math;

    public Student003(String name, int ban, int no, int kor, int eng, int math) {
        this.name = name;
        this.ban = ban;
        this.no = no;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    @Override
    public String toString() {
        return "name=" + name + ", " + "ban=" + ban + ", " + "no=" + no + ", " + "kor=" + kor + ", " + "eng=" + eng + ", " + "math=" + math;
    }

    int getTotal() {
        return kor + eng + math;
    }

    float getAverage() {
        return (float) (Math.round((float) getTotal() / 3 * 10) / 10.0);
    }

    String info() {
        return name + "," + ban + "," + no + "," + kor + "," + eng + "," + math + "," + getTotal() + "," + getAverage();
    }
}


