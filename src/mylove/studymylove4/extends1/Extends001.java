package mylove.studymylove4.extends1;

public class Extends001 {
    public static void main(String[] args) {
        Green mygreen = new Green();
        mygreen.setName("LIGHT-GREEN");
        mygreen.num = 5;
        mygreen.show();

    }
}

class Color extends Object {
    private String name;

    public Color() {
        super();
    }

    public Color(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Green extends Color {
    public int num;

    public Green() {
        super();
    }

    public Green(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void show(){
        System.out.println("NAME :" + getName());
        System.out.println("NUM :" + num);

    }

}


