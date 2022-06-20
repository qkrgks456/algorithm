package mylove.abstracts.abs005;

import java.awt.*;

public abstract class Shape_ex {
    private Point p;

    public Shape_ex() {
        this(new Point(0, 0));
    }

    public Shape_ex(Point p) {
        this.p = p;
    }

    public Point getP() {
        return p;
    }

    public void setP(Point p) {
        this.p = p;
    }

    abstract double calcArea();
}

class Circle_ex extends Shape_ex {
    double r;

    @Override
    double calcArea() {
        return r * r * Math.PI;
    }

    public Circle_ex(int x, int y) {
        super(new Point(x, y));
    }

    public Circle_ex(double r) {
        this.r = r;
    }
}

class Rectangle_ex extends Shape_ex {
    double width;
    double height;

    @Override
    double calcArea() {
        return width * height;
    }

    public Rectangle_ex(int x, int y) {
        super(new Point(x, y));
    }

    public boolean isSquare() {
        if (this.width != 0 && this.height != 0 && this.width == this.height) {
            return true;
        }
        return false;
    }
}
