package mylove.studymylove4.extentds.extends6;

public class User {
    private String name;
    private String id;

    void show() {
        System.out.println("=====================================================================================");
        System.out.println("이름     아이디     JAVA     JSP    MYSQL   SPRING     PROJECT     TOTAL     AVG");
        System.out.println("=====================================================================================");
        System.out.print(this.name + "     " + this.id + "     ");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
