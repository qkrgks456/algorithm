package baekjoon;

import java.awt.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws Exception {
        Map<Integer, Map<Integer, Point>> map = new HashMap<>();
        map.get(0).get(1);

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
