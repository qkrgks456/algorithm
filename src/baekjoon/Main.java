package baekjoon;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println((int)Math.pow(0, 2));
    }
}

class MyComparator implements Comparator<Person> {
    int result = 0;

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.x > o2.x) {
            result = 1;
        } else if (o1.x < o2.x) {
            result = -1;
        } else {
            if (o1.y > o2.y) {
                result = 1;
            } else if (o1.y < o2.y) {
                result = -1;
            }
        }
        return result;
    }
}

class Person {
    int x;
    int y;

    public Person(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Person{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
