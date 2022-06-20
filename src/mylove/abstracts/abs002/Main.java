package mylove.abstracts.abs002;

public class Main {
    public static void main(String[] args) {

        Rectangle rec = new Rectangle();
        rec.showArea(10, 10);

        Triangle tri = new Triangle();
        tri.showArea(10, 10);

        Circle cir = new Circle();
        cir.showArea(10);

    }
}

abstract class Calc {
    int widh;
    int height;
    int radius;

    public Calc() {
        super();
    }

    public Calc(int widh, int height, int radius) {
        this.widh = widh;
        this.height = height;
        this.radius = radius;
    }


    public abstract void showArea(int widh, int height);

    public abstract void showArea(int radius);

}

///////////////////////////
class Rectangle extends Calc {

    public Rectangle() {
        super();
    }

    public Rectangle(int widh, int height, int radius) {
        super(widh, height, radius);
    }

    @Override
    public void showArea(int widh, int height) {

    }

    @Override
    public void showArea(int radius) {

    }
}

class Triangle extends Calc {
    @Override
    public void showArea(int widh, int height) {
        System.out.println(super.widh * super.height / 2);
    }

    @Override
    public void showArea(int radius) {

    }

    public Triangle() {
        super();
    }

    public Triangle(int widh, int height, int radius) {
        super(widh, height, radius);
    }

}

class Circle extends Calc {
    @Override
    public void showArea(int radius) {
        System.out.println((super.radius * super.radius) * Math.PI);
    }

    public Circle() {
        super();
    }

    public Circle(int widh, int height, int radius) {
        super(widh, height, radius);
    }

    @Override
    public void showArea(int widh, int height) {

    }
}
