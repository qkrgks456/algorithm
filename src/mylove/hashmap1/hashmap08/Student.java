package mylove.hashmap1.hashmap08;

import java.util.Objects;

public class Student {
    public int sno;
    public String name;

    public Student(int sno, String name) {
        this.sno = sno;
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        return student.sno == this.sno && student.name == this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sno, name);
    }

}
