package programmers;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Main {


    public static void main(String[] args) {
        Check check = new Check(1, 1, 2, 3);
        Check check1 = new Check(2, 3, 1, 1);
        System.out.println(check.equals(check1));
        Set<Check> set = new HashSet<>();
        System.out.println(check.hashCode());
        System.out.println(check1.hashCode());
        set.add(check);
        set.add(check1);
        System.out.println(set);
    }

}

class Check {
    int x;
    int y;
    int nx;
    int ny;

    public Check(int x, int y, int nx, int ny) {
        this.x = x;
        this.y = y;
        this.nx = nx;
        this.ny = ny;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Check check = (Check) o;
        return /*(x == check.x && y == check.y && nx == check.nx && ny == check.ny)*/
                /*||*/ (x == check.nx && y == check.ny && nx == check.x && ny == check.y);
    }

    @Override
    public int hashCode() {
        int hash = Objects.hash(x, y, nx, ny);
        int hash1 = Objects.hash(nx, ny, x, y);
        return hash + hash1;
    }

    @Override
    public String toString() {
        return "Check{" +
                "x=" + x +
                ", y=" + y +
                ", nx=" + nx +
                ", ny=" + ny +
                '}';
    }
}
