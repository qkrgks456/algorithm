package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Tree> list = new ArrayList<>();
        list.add(new Tree(1, 2, 1));
        list.add(new Tree(1, 1, 3));
        list.add(new Tree(6, 5, 2));
        list.add(new Tree(5, 2, 3));
        list.add(new Tree(5, 2, 2));
        list.add(new Tree(5, 2, 1));
        Collections.sort(list);
        System.out.println(list);
    }
}


class Tree implements Comparable<Tree> {
    int x;
    int y;
    int z;

    public Tree(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "x=" + x +
                ", y=" + y +
                ", z=" + z +
                '}';
    }

    @Override
    public int compareTo(Tree t) {
        return this.z - t.z;
    }
}

