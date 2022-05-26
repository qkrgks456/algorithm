package studymylove3;

public class Test {
    public static void main(String[] args) throws Exception {
        Member member1 = new Member("한솔", 28);
        Member member2 = new Member("정미", 26);
    }
}


class Member {
    static String academy = "구디아카데미";
    String name;
    int age;

    public Member(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
